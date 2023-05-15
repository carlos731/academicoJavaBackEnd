package br.com.senac.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senac.controller.request.EstudanteScoreRequest;
import br.com.senac.controller.response.EstudanteScoreResponse;
import br.com.senac.model.dtos.EstudanteScoreDTO;
import br.com.senac.service.EstudanteScoreService;

@Controller
@RequestMapping("/api/estudante/estudanteScore")
public class EstudanteScoreController {

	@Autowired
	private EstudanteScoreService estudanteScoreService;
	
	@PostMapping
	public ResponseEntity<EstudanteScoreResponse> adicionar(@Valid @RequestBody EstudanteScoreRequest estudanteScoreReq){
		ModelMapper mapper = new ModelMapper();
		EstudanteScoreDTO estudanteScoreDto = mapper.map(estudanteScoreReq, EstudanteScoreDTO.class);
		estudanteScoreDto = estudanteScoreService.adicionar(estudanteScoreDto);
		return new ResponseEntity<>(mapper.map(estudanteScoreDto, EstudanteScoreResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EstudanteScoreResponse>> obterTodos(){
		List<EstudanteScoreDTO> estudanteScores = estudanteScoreService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<EstudanteScoreResponse> resposta = estudanteScores.stream().map(estudanteScore -> mapper.map(estudanteScore, EstudanteScoreResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EstudanteScoreResponse>> obterPorId(@PathVariable Integer id){
		Optional<EstudanteScoreDTO> dto = estudanteScoreService.obterPorId(id);
		EstudanteScoreResponse estudanteScore = new ModelMapper().map(dto.get(), EstudanteScoreResponse.class);
		return new ResponseEntity<>(Optional.of(estudanteScore), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstudanteScoreResponse> atualizar(@Valid @RequestBody EstudanteScoreRequest estudanteScoreReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		EstudanteScoreDTO estudanteScoreDto = mapper.map(estudanteScoreReq, EstudanteScoreDTO.class);
		estudanteScoreDto = estudanteScoreService.atualizar(id, estudanteScoreDto);
		return new ResponseEntity<>(mapper.map(estudanteScoreDto, EstudanteScoreResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		estudanteScoreService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
