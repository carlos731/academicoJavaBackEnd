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

import br.com.senac.controller.request.PeriodoRequest;
import br.com.senac.controller.response.PeriodoResponse;
import br.com.senac.model.dtos.PeriodoDTO;
import br.com.senac.service.PeriodoService;

@RestController
@RequestMapping("/api/periodo")
public class PeriodoController {
	
	@Autowired
	private PeriodoService periodoService;
	
	@PostMapping
	public ResponseEntity<PeriodoResponse> adicionar(@Valid @RequestBody PeriodoRequest periodoReq){
		ModelMapper mapper = new ModelMapper();
		PeriodoDTO periodoDto = mapper.map(periodoReq, PeriodoDTO.class);
		periodoDto = periodoService.adicionar(periodoDto);
		return new ResponseEntity<>(mapper.map(periodoDto, PeriodoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PeriodoResponse>> obterTodos(){
		List<PeriodoDTO> periodos = periodoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<PeriodoResponse> resposta = periodos.stream().map(periodo -> mapper.map(periodo, PeriodoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PeriodoResponse>> obterPorId(@PathVariable Integer id){
		Optional<PeriodoDTO> dto = periodoService.obterPorId(id);
		PeriodoResponse periodo = new ModelMapper().map(dto.get(), PeriodoResponse.class);
		return new ResponseEntity<>(Optional.of(periodo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PeriodoResponse> atualizar(@Valid @RequestBody PeriodoRequest periodoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		PeriodoDTO periodoDto = mapper.map(periodoReq, PeriodoDTO.class);
		periodoDto = periodoService.atualizar(id, periodoDto);
		return new ResponseEntity<>(mapper.map(periodoDto, PeriodoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		periodoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
