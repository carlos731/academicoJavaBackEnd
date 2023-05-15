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

import br.com.senac.controller.request.DiaLetivoRequest;
import br.com.senac.controller.response.DiaLetivoResponse;
import br.com.senac.model.dtos.DiaLetivoDTO;
import br.com.senac.service.DiaLetivoService;

@RestController
@RequestMapping("/api/dia-letivo")
public class DiaLetivoController {

	@Autowired
	private DiaLetivoService diaLetivoService;
	
	@PostMapping
	public ResponseEntity<DiaLetivoResponse> adicionar(@Valid @RequestBody DiaLetivoRequest diaLetivoReq){
		ModelMapper mapper = new ModelMapper();
		DiaLetivoDTO diaLetivoDto = mapper.map(diaLetivoReq, DiaLetivoDTO.class);
		diaLetivoDto = diaLetivoService.adicionar(diaLetivoDto);
		return new ResponseEntity<>(mapper.map(diaLetivoDto, DiaLetivoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<DiaLetivoResponse>> obterTodos(){
		List<DiaLetivoDTO> diaLetivos = diaLetivoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<DiaLetivoResponse> resposta = diaLetivos.stream().map(diaLetivo -> mapper.map(diaLetivo, DiaLetivoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<DiaLetivoResponse>> obterPorId(@PathVariable Integer id){
		Optional<DiaLetivoDTO> dto = diaLetivoService.obterPorId(id);
		DiaLetivoResponse diaLetivo = new ModelMapper().map(dto.get(), DiaLetivoResponse.class);
		return new ResponseEntity<>(Optional.of(diaLetivo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DiaLetivoResponse> atualizar(@Valid @RequestBody DiaLetivoRequest diaLetivoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		DiaLetivoDTO diaLetivoDto = mapper.map(diaLetivoReq, DiaLetivoDTO.class);
		diaLetivoDto = diaLetivoService.atualizar(id, diaLetivoDto);
		return new ResponseEntity<>(mapper.map(diaLetivoDto, DiaLetivoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		diaLetivoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
