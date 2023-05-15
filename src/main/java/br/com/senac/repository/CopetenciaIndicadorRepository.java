package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.CopetenciaIndicador;

@Repository
public interface CopetenciaIndicadorRepository extends JpaRepository<CopetenciaIndicador, Integer>{
	
	
}
