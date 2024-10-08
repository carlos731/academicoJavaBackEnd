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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.controller.request.LoginRequest;
import br.com.senac.controller.request.UsuarioRequest;
import br.com.senac.controller.response.LoginResponse;
import br.com.senac.controller.response.UsuarioResponse;
import br.com.senac.model.Usuario;
import br.com.senac.model.dtos.UsuarioDTO;
import br.com.senac.service.UsuarioService;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginReq){
		ModelMapper mapper = new ModelMapper();
		Usuario usuarioAutenticado = userService.login(loginReq.getEmail(), loginReq.getSenha());
		
		
		return new ResponseEntity<>(mapper.map(usuarioAutenticado, LoginResponse.class), HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<UsuarioResponse> adicionar(@Valid @RequestBody UsuarioRequest userReq){
		ModelMapper mapper = new ModelMapper();
		UsuarioDTO userDto = mapper.map(userReq, UsuarioDTO.class);
		userDto = userService.adicionar(userDto);
		return new ResponseEntity<>(mapper.map(userDto, UsuarioResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponse>> obterTodos(){
		List<UsuarioDTO> users = userService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<UsuarioResponse> resposta = users.stream().map(user -> mapper.map(user, UsuarioResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UsuarioResponse>> obterPorId(@PathVariable Integer id){
		Optional<UsuarioDTO> dto = userService.obterPorId(id);
		UsuarioResponse user = new ModelMapper().map(dto.get(), UsuarioResponse.class);
		return new ResponseEntity<>(Optional.of(user), HttpStatus.OK);
	}
	
	@GetMapping("buscaEmail/{email}")
	public ResponseEntity<Optional<UsuarioResponse>> obterPorEmail(@PathVariable("email") String email){
		Optional<UsuarioDTO> dto = userService.obterPorEmail(email);
		UsuarioResponse user = new ModelMapper().map(dto.get(), UsuarioResponse.class);
		return new ResponseEntity<>(Optional.of(user), HttpStatus.OK);
	}
	
	@GetMapping("buscaCpf/{cpf}")
	public ResponseEntity<Optional<UsuarioResponse>> obterPorCpf(@PathVariable("cpf") String cpf){
		Optional<UsuarioDTO> dto = userService.obterIdPorCpf(cpf);
		UsuarioResponse user = new ModelMapper().map(dto.get(), UsuarioResponse.class);
		return new ResponseEntity<>(Optional.of(user), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponse> atualizar(@Valid @RequestBody UsuarioRequest userReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		UsuarioDTO userDto = mapper.map(userReq, UsuarioDTO.class);
		userDto = userService.atualizar(id, userDto);
		return new ResponseEntity<>(mapper.map(userDto, UsuarioResponse.class), HttpStatus.OK);
	}
	
    @PostMapping("/updateProfileImage")
    public ResponseEntity<UsuarioResponse> uploadFile(@RequestParam("id")Integer id, @RequestParam("file")MultipartFile file) throws Exception {
    	ModelMapper mapper = new ModelMapper();
    	UsuarioDTO userDto = new UsuarioDTO();
    	userDto = userService.updateProfileImage(id, file);
    	return new ResponseEntity<>(mapper.map(userDto, UsuarioResponse.class), HttpStatus.OK);
    
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		userService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
