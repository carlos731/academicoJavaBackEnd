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

import br.com.senac.controller.request.SituacaoAprendizagemRequest;
import br.com.senac.controller.response.SituacaoAprendizagemResponse;
import br.com.senac.model.dtos.SituacaoAprendizagemDTO;
import br.com.senac.service.SituacaoAprendizagemService;

@RestController
@RequestMapping("/api/situacaoAprendizagem")
public class SituacaoAprendizagemController {

	@Autowired
	private SituacaoAprendizagemService situacaoAprendizagemService;
	
	@PostMapping
	public ResponseEntity<SituacaoAprendizagemResponse> adicionar(@Valid @RequestBody SituacaoAprendizagemRequest situacaoAprendizagemReq){
		ModelMapper mapper = new ModelMapper();
		SituacaoAprendizagemDTO situacaoAprendizagemDto = mapper.map(situacaoAprendizagemReq, SituacaoAprendizagemDTO.class);
		situacaoAprendizagemDto = situacaoAprendizagemService.adicionar(situacaoAprendizagemDto);
		return new ResponseEntity<>(mapper.map(situacaoAprendizagemDto, SituacaoAprendizagemResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SituacaoAprendizagemResponse>> obterTodos(){
		List<SituacaoAprendizagemDTO> situacaoAprendizagems = situacaoAprendizagemService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<SituacaoAprendizagemResponse> resposta = situacaoAprendizagems.stream().map(situacaoAprendizagem -> mapper.map(situacaoAprendizagem, SituacaoAprendizagemResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<SituacaoAprendizagemResponse>> obterPorId(@PathVariable Integer id){
		Optional<SituacaoAprendizagemDTO> dto = situacaoAprendizagemService.obterPorId(id);
		SituacaoAprendizagemResponse situacaoAprendizagem = new ModelMapper().map(dto.get(), SituacaoAprendizagemResponse.class);
		return new ResponseEntity<>(Optional.of(situacaoAprendizagem), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SituacaoAprendizagemResponse> atualizar(@Valid @RequestBody SituacaoAprendizagemRequest situacaoAprendizagemReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		SituacaoAprendizagemDTO situacaoAprendizagemDto = mapper.map(situacaoAprendizagemReq, SituacaoAprendizagemDTO.class);
		situacaoAprendizagemDto = situacaoAprendizagemService.atualizar(id, situacaoAprendizagemDto);
		return new ResponseEntity<>(mapper.map(situacaoAprendizagemDto, SituacaoAprendizagemResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		situacaoAprendizagemService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
