package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.Status;
import br.com.senac.model.dtos.UsuarioDTO;
import br.com.senac.repository.UsuarioRepository;
import br.com.senac.service.exceptions.DataIntegrityViolationException;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Usuario login(String email, String senha) {
		Optional<Usuario> usuario = userRepository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ObjectnotFoundException("Usuario não encontrado para o email informado.");
		}
		
		if(usuario.get().getSenha().equals(senha)) {
			throw new DataIntegrityViolationException("Senha inválida.");
		}
		
		/*Response personalizada do login*/
		//LoginResponse loginResponse = new LoginResponse();
		//loginResponse.setId(usuario.get().getId());
		//loginResponse.setNome(usuario.get().getNomeCompleto());
		//loginResponse.setEmail(email);	
		
		return usuario.get();
	}

	public UsuarioDTO adicionar(UsuarioDTO userDto) {
		userDto.setId(null);
		userDto.setStatus(Status.INATIVO);
		userDto.setSenha(encoder.encode(userDto.getSenha()));
		validaPorCpfEEmail(userDto);	
		ModelMapper mapper = new ModelMapper();
		Usuario user = mapper.map(userDto, Usuario.class);
		user = userRepository.save(user);
		userDto.setId(user.getId());
		return userDto;
	}
	
	public List<UsuarioDTO> obterTodos(){
		List<Usuario> users = userRepository.findAll();
		return users.stream().map(user -> new ModelMapper().map(user, UsuarioDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<UsuarioDTO> obterPorId(Integer id){
		Optional<Usuario> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		UsuarioDTO dto = new ModelMapper().map(user.get(), UsuarioDTO.class);
		return Optional.of(dto);
	}
	
	public Optional<UsuarioDTO> obterPorEmail(String email){
		Optional<Usuario> user = userRepository.findByEmail(email);
		
		if(user.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM CPF : '" + email + "' NÃO ENCONTRADO!");
		}
		
		UsuarioDTO dto = new ModelMapper().map(user.get(), UsuarioDTO.class);
		return Optional.of(dto);
	}
	
	public Optional<UsuarioDTO> obterIdPorCpf(String cpf){
		Optional<Usuario> user = userRepository.findByCpf(cpf);
		
		if(user.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM CPF : '" + cpf + "' NÃO ENCONTRADO!");
		}
		
		UsuarioDTO dto = new ModelMapper().map(user.get(), UsuarioDTO.class);
		return Optional.of(dto);
	}
	
	public UsuarioDTO atualizar(Integer id, @Valid UsuarioDTO userDto) {
		Optional<Usuario> userId = userRepository.findById(id);
		
		if(userId.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		//userDto.setUsuario_id(id);
		//UserDTO oldObj = obterPorId(id);
		
		/*if(!userDto.getSenha().equals(userDto.getSenha())) {
			userDto.setSenha(encoder.encode(userDto.getSenha()));
		}*/
		
		userDto.setId(id);
		userDto.setId(id);
		userDto.setSenha(encoder.encode(userDto.getSenha()));
		validaPorCpfEEmail(userDto);
		ModelMapper mapper = new ModelMapper();
		Usuario user = mapper.map(userDto, Usuario.class);
		userRepository.save(user);
		return userDto;
	}
	
	public UsuarioDTO updateProfileImage(Integer id, MultipartFile file) throws Exception {
		Optional<Usuario> userEncontrado = userRepository.findById(id);
		
		if(userEncontrado.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		UsuarioDTO userDto = new UsuarioDTO();
		userDto.setId(id);
		userDto.setCpf(userEncontrado.get().getCpf());
		userDto.setNomeCompleto(userEncontrado.get().getNomeCompleto());
		userDto.setApelido(userEncontrado.get().getApelido());
		userDto.setEmail(userEncontrado.get().getEmail());
		userDto.setDataNascimento(userEncontrado.get().getDataNascimento());
		userDto.setTelefone(userEncontrado.get().getTelefone());
		//userDto.setAtendimentoDataCadastro(userEncontrado.get().getAtendimentoDataCadastro());
		userDto.setFoto(file.getBytes());
		userDto.setPerfis(userEncontrado.get().getPerfis());
		userDto.setSenha(userEncontrado.get().getSenha());
		userDto.setStatus(userEncontrado.get().getStatus());
		
		ModelMapper mapper = new ModelMapper();
		Usuario user = mapper.map(userDto,  Usuario.class) ;
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	      
	    try {
	       if(fileName.contains("..")) {
	         throw  new Exception("Filename contains invalid path sequence " + fileName);
	       }

	      userRepository.save(user);
	      return userDto;

	    } catch (Exception e) {
	       throw new Exception("Could not save File: " + fileName);
	    }
	 }
	
	public void deletar(Integer id) {
		Optional<Usuario> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		userRepository.deleteById(id);
	}
	
	private void validaPorCpfEEmail(UsuarioDTO userDto) {
		Optional<Usuario> obj = userRepository.findByCpf(userDto.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != userDto.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = userRepository.findByEmail(userDto.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != userDto.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}
	
}
