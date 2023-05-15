package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.ScoreNivel;

@Repository
public interface ScoreNivelRepository extends JpaRepository<ScoreNivel, Integer>{

}
