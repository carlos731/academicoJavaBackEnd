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

import br.com.senac.controller.request.ColaboradorRequest;
import br.com.senac.controller.response.ColaboradorResponse;
import br.com.senac.model.dtos.ColaboradorDTO;
import br.com.senac.service.ColaboradorService;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {

	@Autowired 
	private ColaboradorService colaboradorService;
	
	@PostMapping
	public ResponseEntity<ColaboradorResponse> adicionar(@Valid @RequestBody ColaboradorRequest colaboradorReq){
		ModelMapper mapper = new ModelMapper();
		ColaboradorDTO colaboradorDto = mapper.map(colaboradorReq, ColaboradorDTO.class);
		colaboradorDto = colaboradorService.adicionar(colaboradorDto);
		return new ResponseEntity<>(mapper.map(colaboradorDto, ColaboradorResponse.class), HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<ColaboradorResponse>> obterTodos(){
		List<ColaboradorDTO> colaboradores = colaboradorService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ColaboradorResponse> resposta = colaboradores.stream().map(colaborador -> mapper.map(colaborador, ColaboradorResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ColaboradorResponse>> obterPorId(@PathVariable Integer id){
		Optional<ColaboradorDTO> dto = colaboradorService.obterPorId(id);
		ColaboradorResponse colaborador = new ModelMapper().map(dto.get(), ColaboradorResponse.class);
		return new ResponseEntity<>(Optional.of(colaborador), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ColaboradorResponse> atualizar(@Valid @RequestBody ColaboradorRequest colaboradorReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		ColaboradorDTO colaboradorDto = mapper.map(colaboradorReq, ColaboradorDTO.class);
		colaboradorDto = colaboradorService.atualizar(id, colaboradorDto);
		return new ResponseEntity<>(mapper.map(colaboradorDto, ColaboradorResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		colaboradorService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
