package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{
	
}
