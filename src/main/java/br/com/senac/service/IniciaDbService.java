package br.com.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senac.repository.UsuarioRepository;

@Service
public class IniciaDbService {
	
	//@Autowired
	//private UsuarioRepository usuarioRepository;
	
	//@Autowired
	//private ProfessorRepository professorRepository;
	
	@Autowired UsuarioRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		/*Usuario user1 = new Usuario(
				null, 
				"06369408700", 
				"Carlos Henrique", 
				"Carlos", "carlos@gmail.com", 
				null, "9999999999", 
				null, encoder.encode("Senac@123"), 
				1
		);
		user1.addTipo(UsuarioTipo.ADMIN);
		
		Usuario user2 = new Usuario(null, "05532345433", "Eduardo Lucas", "Eduardo", "eduardo@gmail.com", null, "9999999999", null, encoder.encode("Senac@123"), 1);
		user2.addTipo(UsuarioTipo.ESTUDANTE);
		user2.addTipo(UsuarioTipo.PROFESSOR);
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		*/
	
		/*
		Set<UsuarioTipo> perfis = new HashSet<>();
		perfis.add(UsuarioTipo.ADMIN);
		Usuario user1 = new Usuario(null, "06369408700", "Carlos Henrique", "Carlos", "carlos@gmail.com", null, "9999999999", null, null, encoder.encode("Senac@123"), perfis, Status.ATIVO);
		userRepository.save(user1);
		*/
		
		//Professor prof1 = new Professor(null, ProfessorStatus.ATIVO, user1);
		//professorRepository.save(prof1);
	}
}
