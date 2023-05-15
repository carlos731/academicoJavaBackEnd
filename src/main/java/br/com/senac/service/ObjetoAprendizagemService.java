package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.model.ObjetoAprendizagem;
import br.com.senac.model.dtos.ObjetoAprendizagemDTO;
import br.com.senac.repository.ObjetoAprendizagemRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ObjetoAprendizagemService {

	@Autowired
	private ObjetoAprendizagemRepository objetoAprendizagemRepository;
	
	public ObjetoAprendizagemDTO adicionar(ObjetoAprendizagemDTO objetoAprendizagemDto) {
		objetoAprendizagemDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagem objetoAprendizagem = mapper.map(objetoAprendizagemDto, ObjetoAprendizagem.class);
		objetoAprendizagem = objetoAprendizagemRepository.save(objetoAprendizagem);
		objetoAprendizagemDto.setId(objetoAprendizagem.getId());
		return objetoAprendizagemDto;
	}
	
	public ObjetoAprendizagem upload(MultipartFile file, ObjetoAprendizagem objetoAprendizagem) throws Exception {
		   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence " + fileName);
	            }

	            return objetoAprendizagemRepository.save(objetoAprendizagem);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
	}
	
	public List<ObjetoAprendizagemDTO> obterTodos(){
		List<ObjetoAprendizagem> objetoAprendizagems = objetoAprendizagemRepository.findAll();
		return objetoAprendizagems.stream().map(objetoAprendizagem -> new ModelMapper().map(objetoAprendizagem, ObjetoAprendizagemDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<ObjetoAprendizagemDTO> obterPorId(Integer id){
		Optional<ObjetoAprendizagem> objetoAprendizagem = objetoAprendizagemRepository.findById(id);
		
		if(objetoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("OBJETO DE APRENDIZAGEM COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		ObjetoAprendizagemDTO dto = new ModelMapper().map(objetoAprendizagem.get(), ObjetoAprendizagemDTO.class);
		return Optional.of(dto);
	}
	
	public ObjetoAprendizagemDTO atualizar(Integer id, ObjetoAprendizagemDTO objetoAprendizagemDto) {
		Optional<ObjetoAprendizagem> objetoAprendizagemId = objetoAprendizagemRepository.findById(id);
		
		if(objetoAprendizagemId.isEmpty()) {
			throw new ObjectnotFoundException("OBJETO DE APRENDIZAGEM COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		objetoAprendizagemDto.setId(id);
		objetoAprendizagemDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagem objetoAprendizagem = mapper.map(objetoAprendizagemDto, ObjetoAprendizagem.class);
		objetoAprendizagemRepository.save(objetoAprendizagem);
		return objetoAprendizagemDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<ObjetoAprendizagem> objetoAprendizagem = objetoAprendizagemRepository.findById(id);
		
		if(objetoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("OBJETO DE APRENDIZAGEM COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		objetoAprendizagemRepository.deleteById(id);
	}
}
