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

import br.com.senac.controller.request.AtividadeRequest;
import br.com.senac.controller.response.AtividadeResponse;
import br.com.senac.model.dtos.AtividadeDTO;
import br.com.senac.service.AtividadeService;

@RestController
@RequestMapping("/api/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeService atividadeService;
	
	@PostMapping
	public ResponseEntity<AtividadeResponse> adicionar(@Valid @RequestBody AtividadeRequest atividadeReq){
		ModelMapper mapper = new ModelMapper();
		AtividadeDTO atividadeDto = mapper.map(atividadeReq, AtividadeDTO.class);
		atividadeDto = atividadeService.adicionar(atividadeDto);
		return new ResponseEntity<>(mapper.map(atividadeDto, AtividadeResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AtividadeResponse>> obterTodos(){
		List<AtividadeDTO> atividades = atividadeService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<AtividadeResponse> resposta = atividades.stream().map(atividade -> mapper.map(atividade, AtividadeResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<AtividadeResponse>> obterPorId(@PathVariable Integer id){
		Optional<AtividadeDTO> dto = atividadeService.obterPorId(id);
		AtividadeResponse atividade = new ModelMapper().map(dto.get(), AtividadeResponse.class);
		return new ResponseEntity<>(Optional.of(atividade), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AtividadeResponse> atualizar(@Valid @RequestBody AtividadeRequest atividadeReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		AtividadeDTO atividadeDto = mapper.map(atividadeReq, AtividadeDTO.class);
		atividadeDto = atividadeService.atualizar(id, atividadeDto);
		return new ResponseEntity<>(mapper.map(atividadeDto, AtividadeResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		atividadeService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
