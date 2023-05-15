package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.PlanejamentoUc;

@Repository
public interface PlanejamentoUcRepository extends JpaRepository<PlanejamentoUc, Integer>{

}
