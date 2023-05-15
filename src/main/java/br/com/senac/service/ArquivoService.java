package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.model.Arquivo;
import br.com.senac.model.Atividade;
import br.com.senac.model.Enums.ArquivoStatus;
import br.com.senac.model.dtos.ArquivoDTO;
import br.com.senac.repository.ArquivoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ArquivoService {

	@Autowired
	private ArquivoRepository arquivoRepository;
	
	public ArquivoDTO adicionar(ArquivoDTO arquivoDto) {
		arquivoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Arquivo arquivo = mapper.map(arquivoDto, Arquivo.class);	
		arquivo = arquivoRepository.save(arquivo);
		arquivoDto.setId(arquivo.getId());
		return arquivoDto;
	}
	
	public Arquivo upload(MultipartFile file, String descricao, List<Atividade> atividades) throws Exception {
	       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence " + fileName);
	            }
	            Arquivo arquivo = new Arquivo();
	    		arquivo.setDescricao(descricao);
	    		arquivo.setNomeArquivo(file.getOriginalFilename());
	    		arquivo.setBlob(file.getBytes());
	    		arquivo.setExtensao(file.getContentType());
	    		arquivo.setFileSize(file.getSize());
	    		arquivo.setStatus(ArquivoStatus.ATIVO);
	    		arquivo.setAtividades(atividades);
	            return arquivoRepository.save(arquivo);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
	}

	public List<Arquivo> buscar(Arquivo arquivo){
		Example<Arquivo> example = Example.of(arquivo, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return arquivoRepository.findAll(example);
	}
	
	
	public List<ArquivoDTO> obterTodos(){
		List<Arquivo> badges = arquivoRepository.findAll();
		return badges.stream().map(arquivo -> new ModelMapper().map(arquivo, ArquivoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<ArquivoDTO> obterPorId(Integer id){
		Optional<Arquivo> arquivo = arquivoRepository.findById(id);
		
		if(arquivo.isEmpty()) {
			throw new ObjectnotFoundException("ARQUIVO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		ArquivoDTO dto = new ModelMapper().map(arquivo.get(), ArquivoDTO.class);
		return Optional.of(dto);
	}
	
    public Arquivo getArquivo(Integer fileId) throws Exception {
        return arquivoRepository.findById(fileId).orElseThrow( () -> new Exception("File not found with Id: " + fileId));
    }
	
	public void deletar(Integer id) {
		Optional<Arquivo> arquivo = arquivoRepository.findById(id);
		
		if(arquivo.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		arquivoRepository.deleteById(id);
	}
	
	public ArquivoDTO atualizar(Integer id, ArquivoDTO arquivoDto) {
		Optional<Arquivo> badgeId = arquivoRepository.findById(id);
		
		if(badgeId.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		arquivoDto.setId(id);
		arquivoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Arquivo arquivo = mapper.map(arquivoDto, Arquivo.class);
		arquivoRepository.save(arquivo);
		return arquivoDto;
	}
	    
}
