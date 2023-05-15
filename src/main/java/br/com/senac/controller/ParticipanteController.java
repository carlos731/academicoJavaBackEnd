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

import br.com.senac.controller.request.ParticipanteRequest;
import br.com.senac.controller.response.ParticipanteResponse;
import br.com.senac.model.dtos.ParticipanteDTO;
import br.com.senac.service.ParticipanteService;

@RestController
@RequestMapping("api/participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;
	
	@PostMapping
	public ResponseEntity<ParticipanteResponse> adicionar(@Valid @RequestBody ParticipanteRequest participanteReq){
		ModelMapper mapper = new ModelMapper();
		ParticipanteDTO participanteDto = mapper.map(participanteReq, ParticipanteDTO.class);
		participanteDto = participanteService.adicionar(participanteDto);
		return new ResponseEntity<>(mapper.map(participanteDto, ParticipanteResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ParticipanteResponse>> obterTodos(){
		List<ParticipanteDTO> participantes = participanteService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ParticipanteResponse> resposta = participantes.stream().map(participante -> mapper.map(participante, ParticipanteResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ParticipanteResponse>> obterPorId(@PathVariable Integer id){
		Optional<ParticipanteDTO> dto = participanteService.obterPorId(id);
		ParticipanteResponse participante = new ModelMapper().map(dto.get(), ParticipanteResponse.class);
		return new ResponseEntity<>(Optional.of(participante), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParticipanteResponse> atualizar(@Valid @RequestBody ParticipanteRequest participanteReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		ParticipanteDTO participanteDto = mapper.map(participanteReq, ParticipanteDTO.class);
		participanteDto = participanteService.atualizar(id, participanteDto);
		return new ResponseEntity<>(mapper.map(participanteDto, ParticipanteResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		participanteService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
