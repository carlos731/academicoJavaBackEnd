package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer>{
	
	@Query(value = "SELECT * FROM recurso WHERE usuario_id = :usuarioId", nativeQuery = true)
	List<Recurso> findByUsuario(Integer usuarioId);
}
