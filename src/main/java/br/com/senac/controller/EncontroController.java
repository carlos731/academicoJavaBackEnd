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

import br.com.senac.controller.request.EncontroRequest;
import br.com.senac.controller.response.EncontroResponse;
import br.com.senac.model.dtos.EncontroDTO;
import br.com.senac.service.EncontroService;

@RestController
@RequestMapping("/api/encontro")
public class EncontroController {

	@Autowired
	private EncontroService encontroService;
	
	@PostMapping
	public ResponseEntity<EncontroResponse> adicionar(@Valid @RequestBody EncontroRequest encontroReq){
		ModelMapper mapper = new ModelMapper();
		EncontroDTO encontroDto = mapper.map(encontroReq, EncontroDTO.class);
		encontroDto = encontroService.adicionar(encontroDto);
		return new ResponseEntity<>(mapper.map(encontroDto, EncontroResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EncontroResponse>> obterTodos(){
		List<EncontroDTO> encontros = encontroService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<EncontroResponse> resposta = encontros.stream().map(encontro -> mapper.map(encontro, EncontroResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EncontroResponse>> obterPorId(@PathVariable Integer id){
		Optional<EncontroDTO> dto = encontroService.obterPorId(id);
		EncontroResponse encontro = new ModelMapper().map(dto.get(), EncontroResponse.class);
		return new ResponseEntity<>(Optional.of(encontro), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EncontroResponse> atualizar(@Valid @RequestBody EncontroRequest encontroReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		EncontroDTO encontroDto = mapper.map(encontroReq, EncontroDTO.class);
		encontroDto = encontroService.atualizar(id, encontroDto);
		return new ResponseEntity<>(mapper.map(encontroDto, EncontroResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		encontroService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
