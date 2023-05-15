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

import br.com.senac.controller.request.SenacCoinMovimentacaoRequest;
import br.com.senac.controller.response.SenacCoinMovimentacaoResponse;
import br.com.senac.model.dtos.SenacCoinMovimentacaoDTO;
import br.com.senac.service.SenacCoinMovimentacaoService;

@Controller
@RequestMapping("/api/senacCoinMovimentacao")
public class SenacCoinMovimentacaoController {

	@Autowired
	private SenacCoinMovimentacaoService senacCoinMovimentacaoService;;
	
	@PostMapping
	public ResponseEntity<SenacCoinMovimentacaoResponse> adicionar(@Valid @RequestBody SenacCoinMovimentacaoRequest senacCoinMovimentacaoReq){
		ModelMapper mapper = new ModelMapper();
		SenacCoinMovimentacaoDTO senacCoinMovimentacaoDto = mapper.map(senacCoinMovimentacaoReq, SenacCoinMovimentacaoDTO.class);
		senacCoinMovimentacaoDto = senacCoinMovimentacaoService.adicionar(senacCoinMovimentacaoDto);
		return new ResponseEntity<>(mapper.map(senacCoinMovimentacaoDto, SenacCoinMovimentacaoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SenacCoinMovimentacaoResponse>> obterTodos(){
		List<SenacCoinMovimentacaoDTO> senacCoinMovimentacaos = senacCoinMovimentacaoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<SenacCoinMovimentacaoResponse> resposta = senacCoinMovimentacaos.stream().map(senacCoinMovimentacao -> mapper.map(senacCoinMovimentacao, SenacCoinMovimentacaoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<SenacCoinMovimentacaoResponse>> obterPorId(@PathVariable Integer id){
		Optional<SenacCoinMovimentacaoDTO> dto = senacCoinMovimentacaoService.obterPorId(id);
		SenacCoinMovimentacaoResponse senacCoinMovimentacao = new ModelMapper().map(dto.get(), SenacCoinMovimentacaoResponse.class);
		return new ResponseEntity<>(Optional.of(senacCoinMovimentacao), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SenacCoinMovimentacaoResponse> atualizar(@Valid @RequestBody SenacCoinMovimentacaoRequest senacCoinMovimentacaoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		SenacCoinMovimentacaoDTO senacCoinMovimentacaoDto = mapper.map(senacCoinMovimentacaoReq, SenacCoinMovimentacaoDTO.class);
		senacCoinMovimentacaoDto = senacCoinMovimentacaoService.atualizar(id, senacCoinMovimentacaoDto);
		return new ResponseEntity<>(mapper.map(senacCoinMovimentacaoDto, SenacCoinMovimentacaoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		senacCoinMovimentacaoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
