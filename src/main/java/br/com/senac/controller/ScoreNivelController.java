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

import br.com.senac.controller.request.ScoreNivelRequest;
import br.com.senac.controller.response.ScoreNivelResponse;
import br.com.senac.model.dtos.ScoreNivelDTO;
import br.com.senac.service.ScoreNivelService;

@Controller
@RequestMapping("/api/estudante/scoreNivel")
public class ScoreNivelController {

	@Autowired
	private ScoreNivelService scoreNivelService;
	
	@PostMapping
	public ResponseEntity<ScoreNivelResponse> adicionar(@Valid @RequestBody ScoreNivelRequest scoreNivelReq){
		ModelMapper mapper = new ModelMapper();
		ScoreNivelDTO scoreNivelDto = mapper.map(scoreNivelReq, ScoreNivelDTO.class);
		scoreNivelDto = scoreNivelService.adicionar(scoreNivelDto);
		return new ResponseEntity<>(mapper.map(scoreNivelDto, ScoreNivelResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ScoreNivelResponse>> obterTodos(){
		List<ScoreNivelDTO> scoreNivels = scoreNivelService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ScoreNivelResponse> resposta = scoreNivels.stream().map(scoreNivel -> mapper.map(scoreNivel, ScoreNivelResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ScoreNivelResponse>> obterPorId(@PathVariable Integer id){
		Optional<ScoreNivelDTO> dto = scoreNivelService.obterPorId(id);
		ScoreNivelResponse scoreNivel = new ModelMapper().map(dto.get(), ScoreNivelResponse.class);
		return new ResponseEntity<>(Optional.of(scoreNivel), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ScoreNivelResponse> atualizar(@Valid @RequestBody ScoreNivelRequest scoreNivelReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		ScoreNivelDTO scoreNivelDto = mapper.map(scoreNivelReq, ScoreNivelDTO.class);
		scoreNivelDto = scoreNivelService.atualizar(id, scoreNivelDto);
		return new ResponseEntity<>(mapper.map(scoreNivelDto, ScoreNivelResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		scoreNivelService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
