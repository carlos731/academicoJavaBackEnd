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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.controller.request.RecursoRequest;
import br.com.senac.controller.response.RecursoResponse;
import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.Status;
import br.com.senac.model.dtos.RecursoDTO;
import br.com.senac.service.RecursoService;

@RestController
@RequestMapping("/api/recurso")
public class RecursoController {

	@Autowired
	private RecursoService recursoService;
	
	@PostMapping
	public ResponseEntity<RecursoResponse> adicionar(@Valid @RequestBody RecursoRequest recursoReq){
		ModelMapper mapper = new ModelMapper();
		RecursoDTO recursoDto = mapper.map(recursoReq, RecursoDTO.class);
		recursoDto = recursoService.adicionar(recursoDto);
		return new ResponseEntity<>(mapper.map(recursoDto, RecursoResponse.class), HttpStatus.CREATED);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<RecursoResponse> upload(
			@RequestParam("descricao") String descricao, 
			@RequestParam("file") MultipartFile file, 
			@RequestParam("usuarioId") Usuario usuarioId) throws Exception{
		ModelMapper mapper = new ModelMapper();
		RecursoDTO recursoDto = new RecursoDTO();
		recursoDto.setDescricao(descricao);
		recursoDto.setFilename(file.getOriginalFilename());
		recursoDto.setFile(file.getBytes());
		recursoDto.setStatus(Status.ATIVO);
		recursoDto.setUsuarioId(usuarioId);
		recursoDto = recursoService.upload(recursoDto);
		return new ResponseEntity<>(mapper.map(recursoDto, RecursoResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<RecursoResponse>> obterTodos(){
		List<RecursoDTO> recursos = recursoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<RecursoResponse> resposta = recursos.stream().map(recurso -> mapper.map(recurso, RecursoResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<RecursoResponse>> obterPorId(@PathVariable Integer id){
		Optional<RecursoDTO> dto = recursoService.obterPorId(id);
		RecursoResponse recurso = new ModelMapper().map(dto.get(), RecursoResponse.class);
		return new ResponseEntity<>(Optional.of(recurso), HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<RecursoResponse>> obterPorUsuario(@PathVariable Integer usuarioId){
		List<RecursoDTO> recursos = recursoService.obterPorUsuario(usuarioId);
		ModelMapper mapper = new ModelMapper();
		List<RecursoResponse> resposta = recursos.stream().map(recurso -> mapper.map(recurso, RecursoResponse.class)).collect((Collectors.toList()));
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RecursoResponse> atualizar(@Valid @RequestBody RecursoRequest recursoReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		RecursoDTO recursoDto = mapper.map(recursoReq, RecursoDTO.class);
		recursoDto = recursoService.atualizar(id, recursoDto);
		return new ResponseEntity<>(mapper.map(recursoDto, RecursoResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		recursoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
