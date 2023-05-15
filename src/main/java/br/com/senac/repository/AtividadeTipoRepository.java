package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.AtividadeTipo;

@Repository
public interface AtividadeTipoRepository extends JpaRepository<AtividadeTipo, Integer>{

}
