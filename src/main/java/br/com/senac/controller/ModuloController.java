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

import br.com.senac.controller.request.ModuloRequest;
import br.com.senac.controller.response.ModuloResponse;
import br.com.senac.model.dtos.ModuloDTO;
import br.com.senac.service.ModuloService;

@RestController
@RequestMapping("/api/modulo")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	@PostMapping
	public ResponseEntity<ModuloResponse> adicionar(@Valid @RequestBody ModuloRequest ModuloReq){
		ModelMapper mapper = new ModelMapper();
		ModuloDTO ModuloDto = mapper.map(ModuloReq, ModuloDTO.class);
		ModuloDto = moduloService.adicionar(ModuloDto);
		return new ResponseEntity<>(mapper.map(ModuloDto, ModuloResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ModuloResponse>> obterTodos(){
		List<ModuloDTO> modulos = moduloService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ModuloResponse> resposta = modulos.stream().map(modulo -> mapper.map(modulo, ModuloResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ModuloResponse>> obterPorId(@PathVariable Integer id){
		Optional<ModuloDTO> dto = moduloService.obterPorId(id);
		ModuloResponse Modulo = new ModelMapper().map(dto.get(), ModuloResponse.class);
		return new ResponseEntity<>(Optional.of(Modulo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ModuloResponse> atualizar(@Valid @RequestBody ModuloRequest ofertaReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		ModuloDTO moduloDto = mapper.map(ofertaReq, ModuloDTO.class);
		moduloDto = moduloService.atualizar(id, moduloDto);
		return new ResponseEntity<>(mapper.map(moduloDto, ModuloResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		moduloService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
