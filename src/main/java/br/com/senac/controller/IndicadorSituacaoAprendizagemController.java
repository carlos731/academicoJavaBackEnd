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

import br.com.senac.controller.request.IndicadorSituacaoAprendizagemRequest;
import br.com.senac.controller.response.IndicadorSituacaoAprendizagemResponse;
import br.com.senac.model.dtos.IndicadorSituacaoAprendizagemDTO;
import br.com.senac.service.IndicadorSituacaoAprendizagemService;

@RestController
@RequestMapping("/api/indicadorSituacaoAprendizagem")
public class IndicadorSituacaoAprendizagemController {

	@Autowired
	private IndicadorSituacaoAprendizagemService indicadorSituacaoAprendizagemService;
	
	@PostMapping
	public ResponseEntity<IndicadorSituacaoAprendizagemResponse> adicionar(@Valid @RequestBody IndicadorSituacaoAprendizagemRequest indicadorSituacaoAprendizagemReq){
		ModelMapper mapper = new ModelMapper();
		IndicadorSituacaoAprendizagemDTO indicadorSituacaoAprendizagemDto = mapper.map(indicadorSituacaoAprendizagemReq, IndicadorSituacaoAprendizagemDTO.class);
		indicadorSituacaoAprendizagemDto = indicadorSituacaoAprendizagemService.adicionar(indicadorSituacaoAprendizagemDto);
		return new ResponseEntity<>(mapper.map(indicadorSituacaoAprendizagemDto, IndicadorSituacaoAprendizagemResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<IndicadorSituacaoAprendizagemResponse>> obterTodos(){
		List<IndicadorSituacaoAprendizagemDTO> indicadorSituacaoAprendizagems = indicadorSituacaoAprendizagemService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<IndicadorSituacaoAprendizagemResponse> resposta = indicadorSituacaoAprendizagems.stream().map(indicadorSituacaoAprendizagem -> mapper.map(indicadorSituacaoAprendizagem, IndicadorSituacaoAprendizagemResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<IndicadorSituacaoAprendizagemResponse>> obterPorId(@PathVariable Integer id){
		Optional<IndicadorSituacaoAprendizagemDTO> dto = indicadorSituacaoAprendizagemService.obterPorId(id);
		IndicadorSituacaoAprendizagemResponse indicadorSituacaoAprendizagem = new ModelMapper().map(dto.get(), IndicadorSituacaoAprendizagemResponse.class);
		return new ResponseEntity<>(Optional.of(indicadorSituacaoAprendizagem), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<IndicadorSituacaoAprendizagemResponse> atualizar(@Valid @RequestBody IndicadorSituacaoAprendizagemRequest indicadorSituacaoAprendizagemReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		IndicadorSituacaoAprendizagemDTO indicadorSituacaoAprendizagemDto = mapper.map(indicadorSituacaoAprendizagemReq, IndicadorSituacaoAprendizagemDTO.class);
		indicadorSituacaoAprendizagemDto = indicadorSituacaoAprendizagemService.atualizar(id, indicadorSituacaoAprendizagemDto);
		return new ResponseEntity<>(mapper.map(indicadorSituacaoAprendizagemDto, IndicadorSituacaoAprendizagemResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		indicadorSituacaoAprendizagemService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
