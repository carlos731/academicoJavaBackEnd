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

import br.com.senac.controller.request.AvaliacaoTipoRequest;
import br.com.senac.controller.response.AvaliacaoTipoResponse;
import br.com.senac.model.dtos.AvaliacaoTipoDTO;
import br.com.senac.service.AvaliacaoTipoService;

@RestController
@RequestMapping("/api/avaliacaoTipo")
public class AvaliacaoTipoController {

	@Autowired
	private AvaliacaoTipoService avaliacaoTipoService;

	@PostMapping
	public ResponseEntity<AvaliacaoTipoResponse> adicionar(@Valid @RequestBody AvaliacaoTipoRequest avaliacaoTipoReq){
		ModelMapper mapper = new ModelMapper();
		AvaliacaoTipoDTO avaliacaoTipoDto = mapper.map(avaliacaoTipoReq, AvaliacaoTipoDTO.class);
		avaliacaoTipoDto = avaliacaoTipoService.adicionar(avaliacaoTipoDto);
		return new ResponseEntity<>(mapper.map(avaliacaoTipoDto, AvaliacaoTipoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoTipoResponse>> obterTodos(){
		List<AvaliacaoTipoDTO> avaliacaoTipos = avaliacaoTipoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<AvaliacaoTipoResponse> resposta = avaliacaoTipos.stream().map(avaliacaoTipo -> mapper.map(avaliacaoTipo, AvaliacaoTipoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<AvaliacaoTipoResponse>> obterPorId(@PathVariable Integer id){
		Optional<AvaliacaoTipoDTO> dto = avaliacaoTipoService.obterPorId(id);
		AvaliacaoTipoResponse avaliacaoTipo = new ModelMapper().map(dto.get(), AvaliacaoTipoResponse.class);
		return new ResponseEntity<>(Optional.of(avaliacaoTipo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoTipoResponse> atualizar(@Valid @RequestBody AvaliacaoTipoRequest avaliacaoTipoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		AvaliacaoTipoDTO avaliacaoTipoDto = mapper.map(avaliacaoTipoReq, AvaliacaoTipoDTO.class);
		avaliacaoTipoDto = avaliacaoTipoService.atualizar(id, avaliacaoTipoDto);
		return new ResponseEntity<>(mapper.map(avaliacaoTipoDto, AvaliacaoTipoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		avaliacaoTipoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
