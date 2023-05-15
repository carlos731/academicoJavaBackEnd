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

import br.com.senac.controller.request.SenacCoinRequest;
import br.com.senac.controller.response.SenacCoinResponse;
import br.com.senac.model.dtos.SenacCoinDTO;
import br.com.senac.service.SenacCoinService;

@Controller
@RequestMapping("/api/senac-coin")
public class SenacCoinController {
	
	@Autowired
	private SenacCoinService senacCoinService;
	
	@PostMapping
	public ResponseEntity<SenacCoinResponse> adicionar(@Valid @RequestBody SenacCoinRequest senacCoinReq){
		ModelMapper mapper = new ModelMapper();
		SenacCoinDTO senacCoinDto = mapper.map(senacCoinReq, SenacCoinDTO.class);
		senacCoinDto = senacCoinService.adicionar(senacCoinDto);
		return new ResponseEntity<>(mapper.map(senacCoinDto, SenacCoinResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SenacCoinResponse>> obterTodos(){
		List<SenacCoinDTO> senacCoins = senacCoinService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<SenacCoinResponse> resposta = senacCoins.stream().map(senacCoin -> mapper.map(senacCoin, SenacCoinResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<SenacCoinResponse>> obterPorId(@PathVariable Integer id){
		Optional<SenacCoinDTO> dto = senacCoinService.obterPorId(id);
		SenacCoinResponse senacCoin = new ModelMapper().map(dto.get(), SenacCoinResponse.class);
		return new ResponseEntity<>(Optional.of(senacCoin), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SenacCoinResponse> atualizar(@Valid @RequestBody SenacCoinRequest senacCoinReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		SenacCoinDTO senacCoinDto = mapper.map(senacCoinReq, SenacCoinDTO.class);
		senacCoinDto = senacCoinService.atualizar(id, senacCoinDto);
		return new ResponseEntity<>(mapper.map(senacCoinDto, SenacCoinResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		senacCoinService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
