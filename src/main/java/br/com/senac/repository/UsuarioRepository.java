package br.com.senac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);

	//@Query("select user_cpf from userr")
	//public List<User> findByCpfValid();

	//@Query(value = "SELECT user_cpf FROM userr", nativeQuery = true)
	//Optional<User> findByCpf(String cpf);
	
    @Query(value = "SELECT user_email FROM usuario", nativeQuery = true)
    Optional<Usuario> find(String email);
    
    //@Query(value = "SELECT * FROM userr  WHERE usuario_id = :id AND user_status >= 0", nativeQuery = true)
	//Optional<User> buscarUsuariosAtivosPorEmail(String email);
    
}
