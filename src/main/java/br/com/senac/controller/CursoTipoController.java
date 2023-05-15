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

import br.com.senac.controller.request.CursoTipoRequest;
import br.com.senac.controller.response.CursoTipoResponse;
import br.com.senac.model.dtos.CursoTipoDTO;
import br.com.senac.service.CursoTipoService;

@RestController
@RequestMapping("/api/curso-tipo")
public class CursoTipoController {
	
	@Autowired
	private CursoTipoService cursoTipoService;
	
	@PostMapping
	public ResponseEntity<CursoTipoResponse> adicionar(@Valid @RequestBody CursoTipoRequest cursoTipoReq){
		ModelMapper mapper = new ModelMapper();
		CursoTipoDTO cursoTipoDto = mapper.map(cursoTipoReq, CursoTipoDTO.class);
		cursoTipoDto = cursoTipoService.adicionar(cursoTipoDto);
		return new ResponseEntity<>(mapper.map(cursoTipoDto, CursoTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CursoTipoResponse>> obterTodos(){
		List<CursoTipoDTO> cursoTipos = cursoTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CursoTipoResponse> resposta = cursoTipos.stream().map(tipo -> mapper.map(tipo, CursoTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CursoTipoResponse>> obterPorId(@PathVariable Integer id){
		Optional<CursoTipoDTO> dto = cursoTipoService.obterPorId(id);
		CursoTipoResponse cursoTipo = new ModelMapper().map(dto.get(), CursoTipoResponse.class);
		return new ResponseEntity<>(Optional.of(cursoTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoTipoResponse> atualizar(@Valid @RequestBody CursoTipoRequest cursoTipoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		CursoTipoDTO cursoTipoDto = mapper.map(cursoTipoReq, CursoTipoDTO.class);
		cursoTipoDto = cursoTipoService.atualizar(id, cursoTipoDto);
		return new ResponseEntity<>(mapper.map(cursoTipoDto, CursoTipoResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		cursoTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
