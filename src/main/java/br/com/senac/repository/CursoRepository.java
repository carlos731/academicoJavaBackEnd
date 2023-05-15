package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

	@Query(value = "select * from curso where curso_status = 0", nativeQuery = true)
	List<Curso> findByCursosAtivos();
	
	
}
