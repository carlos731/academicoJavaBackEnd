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

import br.com.senac.controller.request.GrauDificuldadeRequest;
import br.com.senac.controller.response.GrauDificuldadeResponse;
import br.com.senac.model.dtos.GrauDificuldadeDTO;
import br.com.senac.service.GrauDificuldadeService;

@RestController
@RequestMapping("api/grauDificuldade")
public class GrauDificuldadeController {

	@Autowired 
	private GrauDificuldadeService grauDificuldadeService;
	
	@PostMapping
	public ResponseEntity<GrauDificuldadeResponse> adicionar(@Valid @RequestBody GrauDificuldadeRequest grauDificuldadeReq){
		ModelMapper mapper = new ModelMapper();
		GrauDificuldadeDTO grauDificuldadeDto = mapper.map(grauDificuldadeReq, GrauDificuldadeDTO.class);
		grauDificuldadeDto = grauDificuldadeService.adicionar(grauDificuldadeDto);
		return new ResponseEntity<>(mapper.map(grauDificuldadeDto, GrauDificuldadeResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<GrauDificuldadeResponse>> obterTodos(){
		List<GrauDificuldadeDTO> grauDificuldades = grauDificuldadeService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<GrauDificuldadeResponse> resposta = grauDificuldades.stream().map(grauDificuldade -> mapper.map(grauDificuldade, GrauDificuldadeResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<GrauDificuldadeResponse>> obterPorId(@PathVariable Integer id){
		Optional<GrauDificuldadeDTO> dto = grauDificuldadeService.obterPorId(id);
		GrauDificuldadeResponse grauDificuldade = new ModelMapper().map(dto.get(), GrauDificuldadeResponse.class);
		return new ResponseEntity<>(Optional.of(grauDificuldade), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GrauDificuldadeResponse> atualizar(@Valid @RequestBody GrauDificuldadeRequest grauDificuldadeReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		GrauDificuldadeDTO grauDificuldadeDto = mapper.map(grauDificuldadeReq, GrauDificuldadeDTO.class);
		grauDificuldadeDto = grauDificuldadeService.atualizar(id, grauDificuldadeDto);
		return new ResponseEntity<>(mapper.map(grauDificuldadeDto, GrauDificuldadeResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		grauDificuldadeService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
