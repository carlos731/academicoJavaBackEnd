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

import br.com.senac.controller.request.ObjetoAprendizagemRequest;
import br.com.senac.controller.response.ObjetoAprendizagemResponse;
import br.com.senac.model.GrauDificuldade;
import br.com.senac.model.ObjetoAprendizagem;
import br.com.senac.model.SituacaoAprendizagem;
import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.ObjetoAprendizagemStatus;
import br.com.senac.model.dtos.ObjetoAprendizagemDTO;
import br.com.senac.service.ObjetoAprendizagemService;

@RestController
@RequestMapping("/api/objetoAprendizagem")
public class ObjetoAprendizagemController {

	@Autowired
	private ObjetoAprendizagemService objetoAprendizagemService;
	
	@PostMapping
	public ResponseEntity<ObjetoAprendizagemResponse> adicionar(@Valid @RequestBody ObjetoAprendizagemRequest objetoAprendizagemReq){
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagemDTO objetoAprendizagemDto = mapper.map(objetoAprendizagemReq, ObjetoAprendizagemDTO.class);
		objetoAprendizagemDto = objetoAprendizagemService.adicionar(objetoAprendizagemDto);
		return new ResponseEntity<>(mapper.map(objetoAprendizagemDto, ObjetoAprendizagemResponse.class), HttpStatus.CREATED);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<ObjetoAprendizagemResponse> upload(
			@RequestParam("descricao") String descricao,
			@RequestParam("file") MultipartFile file,
			@RequestParam("grauDificuldadeId") GrauDificuldade grauDificuldadeId,
			@RequestParam("usuarioId") Usuario usuarioId,
			@RequestParam("aprendizagens") List<SituacaoAprendizagem> aprendizagens
			) throws Exception{
		
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagem objetoAprendizagem = new ObjetoAprendizagem();
		objetoAprendizagem.setDescricao(descricao);
		objetoAprendizagem.setBlob(file.getBytes());
		objetoAprendizagem.setStatus(ObjetoAprendizagemStatus.ATIVO);
		objetoAprendizagem.setGrauDificuldadeId(grauDificuldadeId);
		objetoAprendizagem.setUsuarioId(usuarioId);
		objetoAprendizagem.setAprendizagens(aprendizagens);
		
		objetoAprendizagem = objetoAprendizagemService.upload(file, objetoAprendizagem);
		
		return new ResponseEntity<>(mapper.map(objetoAprendizagem, ObjetoAprendizagemResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ObjetoAprendizagemResponse>> obterTodos(){
		List<ObjetoAprendizagemDTO> objetoAprendizagems = objetoAprendizagemService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ObjetoAprendizagemResponse> resposta = objetoAprendizagems.stream().map(objetoAprendizagem -> mapper.map(objetoAprendizagem, ObjetoAprendizagemResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ObjetoAprendizagemResponse>> obterPorId(@PathVariable Integer id){
		Optional<ObjetoAprendizagemDTO> dto = objetoAprendizagemService.obterPorId(id);
		ObjetoAprendizagemResponse objetoAprendizagem = new ModelMapper().map(dto.get(), ObjetoAprendizagemResponse.class);
		return new ResponseEntity<>(Optional.of(objetoAprendizagem), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ObjetoAprendizagemResponse> atualizar(@Valid @RequestBody ObjetoAprendizagemRequest objetoAprendizagemReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		ObjetoAprendizagemDTO objetoAprendizagemDto = mapper.map(objetoAprendizagemReq, ObjetoAprendizagemDTO.class);
		objetoAprendizagemDto = objetoAprendizagemService.atualizar(id, objetoAprendizagemDto);
		return new ResponseEntity<>(mapper.map(objetoAprendizagemDto, ObjetoAprendizagemResponse.class), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		objetoAprendizagemService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
