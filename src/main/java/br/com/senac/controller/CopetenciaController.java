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

import br.com.senac.controller.request.CopetenciaRequest;
import br.com.senac.controller.response.CopetenciaResponse;
import br.com.senac.model.dtos.CopetenciaDTO;
import br.com.senac.service.CopetenciaService;

@RestController
@RequestMapping("/api/copetencia")
public class CopetenciaController {

	@Autowired
	private CopetenciaService copetenciaService;
	
	@PostMapping
	public ResponseEntity<CopetenciaResponse> adicionar(@Valid @RequestBody CopetenciaRequest copetenciaReq){
		ModelMapper mapper = new ModelMapper();
		CopetenciaDTO copetenciaDto = mapper.map(copetenciaReq, CopetenciaDTO.class);
		copetenciaDto = copetenciaService.adicionar(copetenciaDto);
		return new ResponseEntity<>(mapper.map(copetenciaDto, CopetenciaResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CopetenciaResponse>> obterTodos(){
		List<CopetenciaDTO> copetencias = copetenciaService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CopetenciaResponse> resposta = copetencias.stream().map(copetencia -> mapper.map(copetencia, CopetenciaResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/unidade-curricular/{id}")
	public ResponseEntity<List<CopetenciaResponse>> obterPorUnidadeCurricular(@PathVariable Integer id){
		List<CopetenciaDTO> copetencias = copetenciaService.obterPorUnidadeCurricularId(id);
		ModelMapper mapper = new ModelMapper();
		List<CopetenciaResponse> resposta = copetencias.stream().map(copetencia -> mapper.map(copetencia, CopetenciaResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CopetenciaResponse>> obterPorId(@PathVariable Integer id){
		Optional<CopetenciaDTO> dto = copetenciaService.obterPorId(id);
		CopetenciaResponse copetencia = new ModelMapper().map(dto.get(), CopetenciaResponse.class);
		return new ResponseEntity<>(Optional.of(copetencia), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CopetenciaResponse> atualizar(@Valid @RequestBody CopetenciaRequest copetenciaReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		CopetenciaDTO copetenciaDto = mapper.map(copetenciaReq, CopetenciaDTO.class);
		copetenciaDto = copetenciaService.atualizar(id, copetenciaDto);
		return new ResponseEntity<>(mapper.map(copetenciaDto, CopetenciaResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		copetenciaService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
