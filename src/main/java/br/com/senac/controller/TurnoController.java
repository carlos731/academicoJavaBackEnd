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

import br.com.senac.controller.request.TurnoRequest;
import br.com.senac.controller.response.TurnoResponse;
import br.com.senac.model.dtos.TurnoDTO;
import br.com.senac.service.TurnoService;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

	@Autowired
	private TurnoService turnoService;
	
	@PostMapping
	public ResponseEntity<TurnoResponse> adicionar(@Valid @RequestBody TurnoRequest turnoReq){
		ModelMapper mapper = new ModelMapper();
		TurnoDTO turnoDto = mapper.map(turnoReq, TurnoDTO.class);
		turnoDto = turnoService.adicionar(turnoDto);
		return new ResponseEntity<>(mapper.map(turnoDto, TurnoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<TurnoResponse>> obterTodos(){
		List<TurnoDTO> turnos = turnoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<TurnoResponse> resposta = turnos.stream().map(turno -> mapper.map(turno, TurnoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TurnoResponse>> obterPorId(@PathVariable Integer id){
		Optional<TurnoDTO> dto = turnoService.obterPorId(id);
		TurnoResponse turno = new ModelMapper().map(dto.get(), TurnoResponse.class);
		return new ResponseEntity<>(Optional.of(turno), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TurnoResponse> atualizar(@Valid @RequestBody TurnoRequest turnoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		TurnoDTO turnoDto = mapper.map(turnoReq, TurnoDTO.class);
		turnoDto = turnoService.atualizar(id, turnoDto);
		return new ResponseEntity<>(mapper.map(turnoDto, TurnoResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		turnoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
