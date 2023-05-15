package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Copetencia;

@Repository
public interface CopetenciaRepository extends JpaRepository<Copetencia, Integer>{

	@Query(value = "SELECT * FROM copetencia WHERE unidade_curricular_id = :id", nativeQuery = true)
	List<Copetencia> findByUnidadeCurricularId(Integer id); 
}
