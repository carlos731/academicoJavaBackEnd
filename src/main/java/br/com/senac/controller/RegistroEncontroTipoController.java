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

import br.com.senac.controller.request.RegistroEncontroTipoRequest;
import br.com.senac.controller.response.RegistroEncontroTipoResponse;
import br.com.senac.model.dtos.RegistroEncontroTipoDTO;
import br.com.senac.service.RegistroEncontroTipoService;

@RestController
@RequestMapping("/api/registroEncontroTipo")
public class RegistroEncontroTipoController {

	@Autowired
	private RegistroEncontroTipoService registroEncontroTipoService;
	
	@PostMapping
	public ResponseEntity<RegistroEncontroTipoResponse> adicionar(@Valid @RequestBody RegistroEncontroTipoRequest registroEncontroTipoReq){
		ModelMapper mapper = new ModelMapper();
		RegistroEncontroTipoDTO registroEncontroTipoDto = mapper.map(registroEncontroTipoReq, RegistroEncontroTipoDTO.class);
		registroEncontroTipoDto = registroEncontroTipoService.adicionar(registroEncontroTipoDto);
		return new ResponseEntity<>(mapper.map(registroEncontroTipoDto, RegistroEncontroTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<RegistroEncontroTipoResponse>> obterTodos(){
		List<RegistroEncontroTipoDTO> registroEncontroTipos = registroEncontroTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<RegistroEncontroTipoResponse> resposta = registroEncontroTipos.stream().map(registroEncontroTipo -> mapper.map(registroEncontroTipo, RegistroEncontroTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<RegistroEncontroTipoResponse>> obterPorId(@PathVariable Integer id){
		Optional<RegistroEncontroTipoDTO> dto = registroEncontroTipoService.obterPorId(id);
		RegistroEncontroTipoResponse registroEncontroTipo = new ModelMapper().map(dto.get(), RegistroEncontroTipoResponse.class);
		return new ResponseEntity<>(Optional.of(registroEncontroTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RegistroEncontroTipoResponse> atualizar(@Valid @RequestBody RegistroEncontroTipoRequest registroEncontroTipoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		RegistroEncontroTipoDTO registroEncontroTipoDto = mapper.map(registroEncontroTipoReq, RegistroEncontroTipoDTO.class);
		registroEncontroTipoDto = registroEncontroTipoService.atualizar(id, registroEncontroTipoDto);
		return new ResponseEntity<>(mapper.map(registroEncontroTipoDto, RegistroEncontroTipoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		registroEncontroTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
