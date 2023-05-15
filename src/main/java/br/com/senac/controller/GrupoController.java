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

import br.com.senac.controller.request.GrupoRequest;
import br.com.senac.controller.response.GrupoResponse;
import br.com.senac.model.dtos.GrupoDTO;
import br.com.senac.service.GrupoService;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@PostMapping
	public ResponseEntity<GrupoResponse> adicionar(@Valid @RequestBody GrupoRequest grupoReq){
		ModelMapper mapper = new ModelMapper();
		GrupoDTO grupoDto = mapper.map(grupoReq, GrupoDTO.class);
		grupoDto = grupoService.adicionar(grupoDto);
		return new ResponseEntity<>(mapper.map(grupoDto, GrupoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<GrupoResponse>> obterTodos(){
		List<GrupoDTO> grupos = grupoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<GrupoResponse> resposta = grupos.stream().map(grupo -> mapper.map(grupo, GrupoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<GrupoResponse>> obterPorId(@PathVariable Integer id){
		Optional<GrupoDTO> dto = grupoService.obterPorId(id);
		GrupoResponse grupo = new ModelMapper().map(dto.get(), GrupoResponse.class);
		return new ResponseEntity<>(Optional.of(grupo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GrupoResponse> atualizar(@Valid @RequestBody GrupoRequest grupoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		GrupoDTO grupoDto = mapper.map(grupoReq, GrupoDTO.class);
		grupoDto = grupoService.atualizar(id, grupoDto);
		return new ResponseEntity<>(mapper.map(grupoDto, GrupoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		grupoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
