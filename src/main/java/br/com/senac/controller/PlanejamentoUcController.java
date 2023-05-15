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

import br.com.senac.controller.request.PlanejamentoUcRequest;
import br.com.senac.controller.response.PlanejamentoUcResponse;
import br.com.senac.model.dtos.PlanejamentoUcDTO;
import br.com.senac.service.PlanejamentoUcService;

@RestController
@RequestMapping("/api/planejamentoUc")
public class PlanejamentoUcController {

	@Autowired
	private PlanejamentoUcService planejamentoUcService;
	
	@PostMapping
	public ResponseEntity<PlanejamentoUcResponse> adicionar(@Valid @RequestBody PlanejamentoUcRequest planejamentoUcReq){
		ModelMapper mapper = new ModelMapper();
		PlanejamentoUcDTO planejamentoUcDto = mapper.map(planejamentoUcReq, PlanejamentoUcDTO.class);
		planejamentoUcDto = planejamentoUcService.adicionar(planejamentoUcDto);
		return new ResponseEntity<>(mapper.map(planejamentoUcDto, PlanejamentoUcResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PlanejamentoUcResponse>> obterTodos(){
		List<PlanejamentoUcDTO> planejamentoUcs = planejamentoUcService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<PlanejamentoUcResponse> resposta = planejamentoUcs.stream().map(planejamentoUc -> mapper.map(planejamentoUc, PlanejamentoUcResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PlanejamentoUcResponse>> obterPorId(@PathVariable Integer id){
		Optional<PlanejamentoUcDTO> dto = planejamentoUcService.obterPorId(id);
		PlanejamentoUcResponse planejamentoUc = new ModelMapper().map(dto.get(), PlanejamentoUcResponse.class);
		return new ResponseEntity<>(Optional.of(planejamentoUc), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PlanejamentoUcResponse> atualizar(@Valid @RequestBody PlanejamentoUcRequest planejamentoUcReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		PlanejamentoUcDTO planejamentoUcDto = mapper.map(planejamentoUcReq, PlanejamentoUcDTO.class);
		planejamentoUcDto = planejamentoUcService.atualizar(id, planejamentoUcDto);
		return new ResponseEntity<>(mapper.map(planejamentoUcDto, PlanejamentoUcResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		planejamentoUcService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
