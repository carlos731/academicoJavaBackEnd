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

import br.com.senac.controller.request.AvaliacaoConceitoRequest;
import br.com.senac.controller.response.AvaliacaoConceitoResponse;
import br.com.senac.model.dtos.AvaliacaoConceitoDTO;
import br.com.senac.service.AvaliacaoConceitoService;

@RestController
@RequestMapping("/api/avaliacaoConceito")
public class AvaliacaoConceitoController {

	@Autowired
	private AvaliacaoConceitoService avaliacaoConceitoService;
	
	@PostMapping
	public ResponseEntity<AvaliacaoConceitoResponse> adicionar(@Valid @RequestBody AvaliacaoConceitoRequest avaliacaoConceitoReq){
		ModelMapper mapper = new ModelMapper();
		AvaliacaoConceitoDTO avaliacaoConceitoDto = mapper.map(avaliacaoConceitoReq, AvaliacaoConceitoDTO.class);
		avaliacaoConceitoDto = avaliacaoConceitoService.adicionar(avaliacaoConceitoDto);
		return new ResponseEntity<>(mapper.map(avaliacaoConceitoDto, AvaliacaoConceitoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoConceitoResponse>> obterTodos(){
		List<AvaliacaoConceitoDTO> avaliacaoConceitos = avaliacaoConceitoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<AvaliacaoConceitoResponse> resposta = avaliacaoConceitos.stream().map(avaliacaoConceito -> mapper.map(avaliacaoConceito, AvaliacaoConceitoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<AvaliacaoConceitoResponse>> obterPorId(@PathVariable Integer id){
		Optional<AvaliacaoConceitoDTO> dto = avaliacaoConceitoService.obterPorId(id);
		AvaliacaoConceitoResponse avaliacaoConceito = new ModelMapper().map(dto.get(), AvaliacaoConceitoResponse.class);
		return new ResponseEntity<>(Optional.of(avaliacaoConceito), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoConceitoResponse> atualizar(@Valid @RequestBody AvaliacaoConceitoRequest avaliacaoConceitoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		AvaliacaoConceitoDTO avaliacaoConceitoDto = mapper.map(avaliacaoConceitoReq, AvaliacaoConceitoDTO.class);
		avaliacaoConceitoDto = avaliacaoConceitoService.atualizar(id, avaliacaoConceitoDto);
		return new ResponseEntity<>(mapper.map(avaliacaoConceitoDto, AvaliacaoConceitoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		avaliacaoConceitoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
