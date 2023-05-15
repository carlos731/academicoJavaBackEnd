package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.UnidadeCurricular;
import br.com.senac.model.dtos.UnidadeCurricularDTO;
import br.com.senac.repository.UnidadeCurricularRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class UnidadeCurricularService {

	@Autowired
	private UnidadeCurricularRepository unidadeCurricularRepository;
	
	public UnidadeCurricularDTO adicionar(UnidadeCurricularDTO unidadeCurricularDto) {
		unidadeCurricularDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		UnidadeCurricular unidadeCurricular = mapper.map(unidadeCurricularDto, UnidadeCurricular.class);
		unidadeCurricular = unidadeCurricularRepository.save(unidadeCurricular);
		unidadeCurricularDto.setId(unidadeCurricular.getId());
		return unidadeCurricularDto;
	}
	
	public List<UnidadeCurricularDTO> obterTodos(){
		List<UnidadeCurricular> unidadeCurriculares = unidadeCurricularRepository.findAll();
		return unidadeCurriculares.stream().map(unidadeCurricular -> new ModelMapper().map(unidadeCurricular, UnidadeCurricularDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<UnidadeCurricularDTO> obterPorId(Integer id){
		Optional<UnidadeCurricular> unidadeCurricular = unidadeCurricularRepository.findById(id);
		
		if(unidadeCurricular.isEmpty()) {
			throw new ObjectnotFoundException("UNIDADE CURRICULAR COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		UnidadeCurricularDTO dto = new ModelMapper().map(unidadeCurricular.get(), UnidadeCurricularDTO.class);
		return Optional.of(dto);
	}
	
	public UnidadeCurricularDTO atualizar(Integer id, UnidadeCurricularDTO unidadeCurricularDto) {
		Optional<UnidadeCurricular> unidadeCurricularId = unidadeCurricularRepository.findById(id);
		
		if(unidadeCurricularId.isEmpty()) {
			throw new ObjectnotFoundException("UNIDADE CURRICULAR COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		unidadeCurricularDto.setId(id);
		unidadeCurricularDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		UnidadeCurricular unidadeCurricular = mapper.map(unidadeCurricularDto, UnidadeCurricular.class);
		unidadeCurricularRepository.save(unidadeCurricular);
		return unidadeCurricularDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<UnidadeCurricular> unidadeCurricular = unidadeCurricularRepository.findById(id);
		
		if(unidadeCurricular.isEmpty()) {
			throw new ObjectnotFoundException("UNIDADE CURRICULAR COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		unidadeCurricularRepository.deleteById(id);
	}

}
