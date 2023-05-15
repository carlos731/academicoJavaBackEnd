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

import br.com.senac.controller.request.AtividadeTipoRequest;
import br.com.senac.controller.response.AtividadeTipoResponse;
import br.com.senac.model.dtos.AtividadeTipoDTO;
import br.com.senac.service.AtividadeTipoService;

@RestController
@RequestMapping("/api/atividadeTipo")
public class AtividadeTipoController {

	@Autowired 
	private AtividadeTipoService atividadeTipoService;
	
	@PostMapping
	public ResponseEntity<AtividadeTipoResponse> adicionar(@Valid @RequestBody AtividadeTipoRequest atividadeTipoReq){
		ModelMapper mapper = new ModelMapper();
		AtividadeTipoDTO atividadeTipoDto = mapper.map(atividadeTipoReq, AtividadeTipoDTO.class);
		atividadeTipoDto = atividadeTipoService.adicionar(atividadeTipoDto);
		return new ResponseEntity<>(mapper.map(atividadeTipoDto, AtividadeTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AtividadeTipoResponse>> obterTodos(){
		List<AtividadeTipoDTO> atividadeTipos = atividadeTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<AtividadeTipoResponse> resposta = atividadeTipos.stream().map(atividadeTipo -> mapper.map(atividadeTipo, AtividadeTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<AtividadeTipoResponse>> obterPorId(@PathVariable Integer id){
		Optional<AtividadeTipoDTO> dto = atividadeTipoService.obterPorId(id);
		AtividadeTipoResponse atividadeTipo = new ModelMapper().map(dto.get(), AtividadeTipoResponse.class);
		return new ResponseEntity<>(Optional.of(atividadeTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AtividadeTipoResponse> atualizar(@Valid @RequestBody AtividadeTipoRequest atividadeTipoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		AtividadeTipoDTO atividadeTipoDto = mapper.map(atividadeTipoReq, AtividadeTipoDTO.class);
		atividadeTipoDto = atividadeTipoService.atualizar(id, atividadeTipoDto);
		return new ResponseEntity<>(mapper.map(atividadeTipoDto, AtividadeTipoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		atividadeTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
