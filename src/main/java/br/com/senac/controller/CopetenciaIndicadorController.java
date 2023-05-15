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

import br.com.senac.controller.request.CopetenciaIndicadorRequest;
import br.com.senac.controller.response.CopetenciaIndicadorResponse;
import br.com.senac.model.dtos.CopetenciaIndicadorDTO;
import br.com.senac.service.CopetenciaIndicadorService;

@RestController
@RequestMapping("/api/copetencia-indicador")
public class CopetenciaIndicadorController {

	@Autowired
	private CopetenciaIndicadorService copetenciaIndicadorService;
	
	@PostMapping
	public ResponseEntity<CopetenciaIndicadorResponse> adicionar(@Valid @RequestBody CopetenciaIndicadorRequest copetenciaIndicadorReq){
		ModelMapper mapper = new ModelMapper();
		CopetenciaIndicadorDTO copetenciaIndicadorDto = mapper.map(copetenciaIndicadorReq, CopetenciaIndicadorDTO.class);
		copetenciaIndicadorDto = copetenciaIndicadorService.adicionar(copetenciaIndicadorDto);
		return new ResponseEntity<>(mapper.map(copetenciaIndicadorDto, CopetenciaIndicadorResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CopetenciaIndicadorResponse>> obterTodos(){
		List<CopetenciaIndicadorDTO> copetenciaIndicadores = copetenciaIndicadorService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<CopetenciaIndicadorResponse> resposta = copetenciaIndicadores.stream().map(copetenciaIndicador -> mapper.map(copetenciaIndicador, CopetenciaIndicadorResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CopetenciaIndicadorResponse>> obterPorId(@PathVariable Integer id){
		Optional<CopetenciaIndicadorDTO> dto = copetenciaIndicadorService.obterPorId(id);
		CopetenciaIndicadorResponse copetenciaIndicador = new ModelMapper().map(dto.get(), CopetenciaIndicadorResponse.class);
		return new ResponseEntity<>(Optional.of(copetenciaIndicador), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CopetenciaIndicadorResponse> atualizar(@Valid @RequestBody CopetenciaIndicadorRequest copetenciaIndicadorReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		CopetenciaIndicadorDTO copetenciaIndicadorDto = mapper.map(copetenciaIndicadorReq, CopetenciaIndicadorDTO.class);
		copetenciaIndicadorDto = copetenciaIndicadorService.atualizar(id, copetenciaIndicadorDto);
		return new ResponseEntity<>(mapper.map(copetenciaIndicadorDto, CopetenciaIndicadorResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		copetenciaIndicadorService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
