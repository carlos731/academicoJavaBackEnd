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

import br.com.senac.controller.request.RegistroAvaliacaoRequest;
import br.com.senac.controller.response.RegistroAvaliacaoResponse;
import br.com.senac.model.dtos.RegistroAvaliacaoDTO;
import br.com.senac.service.RegistroAvaliacaoService;

@RestController
@RequestMapping("/api/registroAvaliacao")
public class RegistroAvaliacaoController {

	@Autowired
	private RegistroAvaliacaoService registroAvaliacaoService;
	
	@PostMapping
	public ResponseEntity<RegistroAvaliacaoResponse> adicionar(@Valid @RequestBody RegistroAvaliacaoRequest registroAvaliacaoReq){
		ModelMapper mapper = new ModelMapper();
		RegistroAvaliacaoDTO registroAvaliacaoDto = mapper.map(registroAvaliacaoReq, RegistroAvaliacaoDTO.class);
		registroAvaliacaoDto = registroAvaliacaoService.adicionar(registroAvaliacaoDto);
		return new ResponseEntity<>(mapper.map(registroAvaliacaoDto, RegistroAvaliacaoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<RegistroAvaliacaoResponse>> obterTodos(){
		List<RegistroAvaliacaoDTO> registroAvaliacoes = registroAvaliacaoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<RegistroAvaliacaoResponse> resposta = registroAvaliacoes.stream().map(registroAvaliacao -> mapper.map(registroAvaliacao, RegistroAvaliacaoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<RegistroAvaliacaoResponse>> obterPorId(@PathVariable Integer id){
		Optional<RegistroAvaliacaoDTO> dto = registroAvaliacaoService.obterPorId(id);
		RegistroAvaliacaoResponse registroAvaliacao = new ModelMapper().map(dto.get(), RegistroAvaliacaoResponse.class);
		return new ResponseEntity<>(Optional.of(registroAvaliacao), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RegistroAvaliacaoResponse> atualizar(@Valid @RequestBody RegistroAvaliacaoRequest registroAvaliacaoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		RegistroAvaliacaoDTO registroAvaliacaoDto = mapper.map(registroAvaliacaoReq, RegistroAvaliacaoDTO.class);
		registroAvaliacaoDto = registroAvaliacaoService.atualizar(id, registroAvaliacaoDto);
		return new ResponseEntity<>(mapper.map(registroAvaliacaoDto, RegistroAvaliacaoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		registroAvaliacaoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
