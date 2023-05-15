package br.com.senac.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.controller.request.UnidadeCurricularRequest;
import br.com.senac.controller.response.UnidadeCurricularResponse;
import br.com.senac.model.dtos.UnidadeCurricularDTO;
import br.com.senac.service.UnidadeCurricularService;

@RestController
@RequestMapping("/api/unidade-curricular")
public class UnidadeCurricularController {
	
	@Autowired
	private UnidadeCurricularService unidadeCurricularService;
	
	@PostMapping
	public ResponseEntity<UnidadeCurricularResponse> adicionar(@Valid @RequestBody UnidadeCurricularRequest unidadeCurricularReq){
		ModelMapper mapper = new ModelMapper();
		UnidadeCurricularDTO unidadeCurricularDto = mapper.map(unidadeCurricularReq, UnidadeCurricularDTO.class);
		unidadeCurricularDto = unidadeCurricularService.adicionar(unidadeCurricularDto);
		return new ResponseEntity<>(mapper.map(unidadeCurricularDto, UnidadeCurricularResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UnidadeCurricularResponse>> obterTodos(){
		List<UnidadeCurricularDTO> unidadeCurriculares = unidadeCurricularService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<UnidadeCurricularResponse> resposta = unidadeCurriculares.stream().map(unidadeCurricular -> mapper.map(unidadeCurricular, UnidadeCurricularResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UnidadeCurricularResponse>> obterPorId(@PathVariable Integer id){
		Optional<UnidadeCurricularDTO> dto = unidadeCurricularService.obterPorId(id);
		UnidadeCurricularResponse unidadeCurricular = new ModelMapper().map(dto.get(), UnidadeCurricularResponse.class);
		return new ResponseEntity<>(Optional.of(unidadeCurricular), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UnidadeCurricularResponse> atualizar(@Valid @RequestBody UnidadeCurricularRequest unidadeCurricularReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		UnidadeCurricularDTO unidadeCurricularDto = mapper.map(unidadeCurricularReq, UnidadeCurricularDTO.class);
		unidadeCurricularDto = unidadeCurricularService.atualizar(id, unidadeCurricularDto);
		return new ResponseEntity<>(mapper.map(unidadeCurricularDto, UnidadeCurricularResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		unidadeCurricularService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
