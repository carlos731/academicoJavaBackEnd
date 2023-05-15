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

import br.com.senac.controller.request.CursoRequest;
import br.com.senac.controller.response.CursoResponse;
import br.com.senac.model.dtos.CursoDTO;
import br.com.senac.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<CursoResponse> adicionar(@Valid @RequestBody CursoRequest cursoReq){
		ModelMapper mapper = new ModelMapper();
		CursoDTO cursoDto = mapper.map(cursoReq, CursoDTO.class);
		cursoDto = cursoService.adicionar(cursoDto);
		return new ResponseEntity<>(mapper.map(cursoDto, CursoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CursoResponse>> obterTodos(){
		List<CursoDTO> cursos = cursoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CursoResponse> resposta = cursos.stream().map(curso -> mapper.map(curso, CursoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CursoResponse>> obterPorId(@PathVariable Integer id){
		Optional<CursoDTO> dto = cursoService.obterPorId(id);
		CursoResponse curso = new ModelMapper().map(dto.get(), CursoResponse.class);
		return new ResponseEntity<>(Optional.of(curso), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoResponse> atualizar(@Valid @RequestBody CursoRequest cursoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		CursoDTO cursoDto = mapper.map(cursoReq, CursoDTO.class);
		cursoDto = cursoService.atualizar(id, cursoDto);
		return new ResponseEntity<>(mapper.map(cursoDto, CursoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		cursoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
