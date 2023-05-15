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

import br.com.senac.controller.request.EstudanteRequest;
import br.com.senac.controller.response.EstudanteResponse;
import br.com.senac.model.dtos.EstudanteDTO;
import br.com.senac.service.EstudanteService;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
	
	@PostMapping
	public ResponseEntity<EstudanteResponse> adicionar(@Valid @RequestBody EstudanteRequest estudanteReq){
		ModelMapper mapper = new ModelMapper();
		EstudanteDTO estudanteDto = mapper.map(estudanteReq, EstudanteDTO.class);
		estudanteDto = estudanteService.adicionar(estudanteDto);
		return new ResponseEntity<>(mapper.map(estudanteDto, EstudanteResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EstudanteResponse>> obterTodos(){
		List<EstudanteDTO> estudantes = estudanteService.obterTodos();	
		ModelMapper mapper = new ModelMapper();
		List<EstudanteResponse> resposta = estudantes.stream().map(estudante -> mapper.map(estudante, EstudanteResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EstudanteResponse>> obterPorId(@PathVariable Integer id){
		Optional<EstudanteDTO> dto = estudanteService.obterPorId(id);
		EstudanteResponse estudante = new ModelMapper().map(dto.get(), EstudanteResponse.class);
		return new ResponseEntity<>(Optional.of(estudante), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstudanteResponse> atualizar(@Valid @RequestBody EstudanteRequest estudanteReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		EstudanteDTO estudanteDto = mapper.map(estudanteReq, EstudanteDTO.class);
		estudanteDto = estudanteService.atualizar(id, estudanteDto);
		return new ResponseEntity<>(mapper.map(estudanteDto, EstudanteResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		estudanteService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
