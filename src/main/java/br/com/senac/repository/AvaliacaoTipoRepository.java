package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.AvaliacaoTipo;

@Repository
public interface AvaliacaoTipoRepository extends JpaRepository<AvaliacaoTipo, Integer>{

}
