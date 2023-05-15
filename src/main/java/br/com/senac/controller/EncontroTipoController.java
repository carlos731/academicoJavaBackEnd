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

import br.com.senac.controller.request.EncontroTipoRequest;
import br.com.senac.controller.response.EncontroTipoResponse;
import br.com.senac.model.dtos.EncontroTipoDTO;
import br.com.senac.service.EncontroTipoService;

@RestController
@RequestMapping("/api/encontro-tipo")
public class EncontroTipoController {
	
	@Autowired
	private EncontroTipoService encontroTipoService;
	
	@PostMapping
	public ResponseEntity<EncontroTipoResponse> adicionar(@Valid @RequestBody EncontroTipoRequest encontroTipoReq){
		ModelMapper mapper = new ModelMapper();
		EncontroTipoDTO encontroTipoDto = mapper.map(encontroTipoReq, EncontroTipoDTO.class);
		encontroTipoDto = encontroTipoService.adicionar(encontroTipoDto);
		return new ResponseEntity<>(mapper.map(encontroTipoDto, EncontroTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EncontroTipoResponse>> obterTodos(){
		List<EncontroTipoDTO> encontroTipos = encontroTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<EncontroTipoResponse> resposta = encontroTipos.stream().map(encontroTipo -> mapper.map(encontroTipo, EncontroTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EncontroTipoResponse>> obterPorId(@PathVariable Integer id){
		Optional<EncontroTipoDTO> dto = encontroTipoService.obterPorId(id);
		EncontroTipoResponse encontroTipo = new ModelMapper().map(dto.get(), EncontroTipoResponse.class);
		return new ResponseEntity<>(Optional.of(encontroTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EncontroTipoResponse> atualizar(@Valid @RequestBody EncontroTipoRequest encontroTipoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		EncontroTipoDTO encontroTipoDto = mapper.map(encontroTipoReq, EncontroTipoDTO.class);
		encontroTipoDto = encontroTipoService.atualizar(id, encontroTipoDto);
		return new ResponseEntity<>(mapper.map(encontroTipoDto, EncontroTipoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		encontroTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
