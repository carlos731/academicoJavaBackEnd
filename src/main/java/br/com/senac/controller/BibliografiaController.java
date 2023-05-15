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

import br.com.senac.controller.request.BibliografiaRequest;
import br.com.senac.controller.response.BibliografiaResponse;
import br.com.senac.model.dtos.BibliografiaDTO;
import br.com.senac.service.BibliografiaService;

@RestController
@RequestMapping("/api/unidade-curricular/bibliografia")///api/unidade-curricular/bibliografia
public class BibliografiaController {
	
	@Autowired
	private BibliografiaService bibliografiaService;
	
	@PostMapping
	public ResponseEntity<BibliografiaResponse> adicionar(@Valid @RequestBody BibliografiaRequest bibliografiaReq){
		ModelMapper mapper = new ModelMapper();
		BibliografiaDTO bibliografiaDto = mapper.map(bibliografiaReq, BibliografiaDTO.class);
		bibliografiaDto = bibliografiaService.adicionar(bibliografiaDto);
		return new ResponseEntity<>(mapper.map(bibliografiaDto, BibliografiaResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BibliografiaResponse>> obterTodos(){
		List<BibliografiaDTO> cursos = bibliografiaService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<BibliografiaResponse> resposta = cursos.stream().map(curso -> mapper.map(curso, BibliografiaResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<BibliografiaResponse>> obterPorId(@PathVariable Integer id){
		Optional<BibliografiaDTO> dto = bibliografiaService.obterPorId(id);
		BibliografiaResponse curso = new ModelMapper().map(dto.get(), BibliografiaResponse.class);
		return new ResponseEntity<>(Optional.of(curso), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BibliografiaResponse> atualizar(@Valid @RequestBody BibliografiaRequest bibliografiaReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		BibliografiaDTO bibliografiaDto = mapper.map(bibliografiaReq, BibliografiaDTO.class);
		bibliografiaDto = bibliografiaService.atualizar(id, bibliografiaDto);
		return new ResponseEntity<>(mapper.map(bibliografiaDto, BibliografiaResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		bibliografiaService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
