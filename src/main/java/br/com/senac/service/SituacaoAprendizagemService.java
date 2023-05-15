package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.SituacaoAprendizagem;
import br.com.senac.model.dtos.SituacaoAprendizagemDTO;
import br.com.senac.repository.SituacaoAprendizagemRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class SituacaoAprendizagemService {
	
	@Autowired
	private SituacaoAprendizagemRepository situacaoAprendizagemRepository;
	
	public SituacaoAprendizagemDTO adicionar(SituacaoAprendizagemDTO situacaoAprendizagemDto) {
		situacaoAprendizagemDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		SituacaoAprendizagem situacaoAprendizagem = mapper.map(situacaoAprendizagemDto, SituacaoAprendizagem.class);
		situacaoAprendizagem = situacaoAprendizagemRepository.save(situacaoAprendizagem);
		situacaoAprendizagemDto.setId(situacaoAprendizagem.getId());
		return situacaoAprendizagemDto;
	}
	
	public List<SituacaoAprendizagemDTO> obterTodos(){
		List<SituacaoAprendizagem> situacaoAprendizagems = situacaoAprendizagemRepository.findAll();
		return situacaoAprendizagems.stream().map(situacaoAprendizagem -> new ModelMapper().map(situacaoAprendizagem, SituacaoAprendizagemDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<SituacaoAprendizagemDTO> obterPorId(Integer id){
		Optional<SituacaoAprendizagem> situacaoAprendizagem = situacaoAprendizagemRepository.findById(id);
		
		if(situacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("SITUAÇÃO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		SituacaoAprendizagemDTO dto = new ModelMapper().map(situacaoAprendizagem.get(), SituacaoAprendizagemDTO.class);
		return Optional.of(dto);
	}
	
	public SituacaoAprendizagemDTO atualizar(Integer id, SituacaoAprendizagemDTO situacaoAprendizagemDto) {
		Optional<SituacaoAprendizagem> situacaoAprendizagemId = situacaoAprendizagemRepository.findById(id);
		
		if(situacaoAprendizagemId.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		situacaoAprendizagemDto.setId(id);
		situacaoAprendizagemDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		SituacaoAprendizagem situacaoAprendizagem = mapper.map(situacaoAprendizagemDto, SituacaoAprendizagem.class);
		situacaoAprendizagemRepository.save(situacaoAprendizagem);
		return situacaoAprendizagemDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<SituacaoAprendizagem> situacaoAprendizagem = situacaoAprendizagemRepository.findById(id);
		
		if(situacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		situacaoAprendizagemRepository.deleteById(id);
	}
}
