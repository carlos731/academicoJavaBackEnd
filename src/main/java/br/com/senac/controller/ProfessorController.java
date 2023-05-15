package br.com.senac.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.controller.request.ProfessorRequest;
import br.com.senac.controller.response.ProfessorResponse;
import br.com.senac.model.dtos.ProfessorDTO;
import br.com.senac.service.ProfessorService;

@RestController
@RequestMapping("api/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ProfessorResponse> adicionar(@Valid @RequestBody ProfessorRequest professorReq){
		//Usuario usuario = new Usuario();
		ModelMapper mapper = new ModelMapper();
		
		ProfessorDTO professorDto = mapper.map(professorReq, ProfessorDTO.class);
		
		//usuario.setUsuario_id(professorReq.getUsuario_id());
		
		/*usuario.setCpf(usuario.getCpf());
		usuario.setNomeCompleto(professorDto.getUsuario_id().getNomeCompleto());
		usuario.setApelido(professorDto.getUsuario_id().getApelido());
		usuario.setEmail(professorDto.getUsuario_id().getEmail());
		usuario.setDataNascimento(professorDto.getUsuario_id().getDataNascimento());
		usuario.setUsuarioTelefone(professorDto.getUsuario_id().getUsuarioTelefone());
		usuario.setDataCadastro(professorDto.getUsuario_id().getDataCadastro());
		usuario.setFoto(professorDto.getUsuario_id().getFoto());
		//usuario.addTipo(professorDto.getUsuario_id().getTipo());
		usuario.setSenha(professorDto.getUsuario_id().getSenha());
		usuario.setStatus(professorDto.getUsuario_id().getStatus());
		*/
		
		//professorDto.setProfessor_status(professorReq.getProfessor_status());
		//professorDto.setUsuario_id(usuario);
		
		//Converter<Integer, Usuario> usuarioIdConverter = ctx -> ctx.getDestination();
		professorDto = professorService.adicionar(professorDto);
		return new ResponseEntity<>(mapper.map(professorDto, ProfessorResponse.class), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProfessorResponse>> obterTodos(){
		List<ProfessorDTO> professores = professorService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ProfessorResponse> resposta = professores.stream().map(professor -> mapper.map(professor, ProfessorResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProfessorResponse>> obterPorId(@PathVariable Integer id){
		Optional<ProfessorDTO> dto = professorService.obterPorId(id);
		ProfessorResponse professor = new ModelMapper().map(dto.get(), ProfessorResponse.class);
		return new ResponseEntity<>(Optional.of(professor), HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id){
		professorService.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfessorResponse> atualizar(@Valid @RequestBody ProfessorRequest professorReq, @PathVariable Integer id){
		//Usuario usuario = new Usuario();
		ModelMapper mapper = new ModelMapper();
		ProfessorDTO professorDto = mapper.map(professorReq,  ProfessorDTO.class);
		//usuario.setUsuario_id(professorReq.getUsuario_id());
		//professorDto.setProfessor_status(professorReq.getProfessor_status());
		//professorDto.setUsuario_id(usuario);
		professorDto = professorService.atualizar(id, professorDto);
		return new ResponseEntity<>(mapper.map(professorDto, ProfessorResponse.class), HttpStatus.OK);
	}
}

/*@DeleteMapping("/{id}")
	public ResponseEntity<ProfessorResponse> deletar(@RequestBody ProfessorRequest professorReq, @PathVariable Integer id){
		professorService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
*/