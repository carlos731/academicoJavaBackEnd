package br.com.senac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.senac.model.Usuario;
import br.com.senac.repository.UsuarioRepository;
import br.com.senac.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findByCpf(cpf);
		if(user.isPresent()) {
			return new UserSS(user.get().getId(), user.get().getCpf(), user.get().getSenha(), user.get().getPerfis());
		}
		throw new UsernameNotFoundException(cpf);
	}
	
}
