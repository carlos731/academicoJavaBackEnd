package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.EstudanteScore;

@Repository
public interface EstudanteScoreRepository extends JpaRepository<EstudanteScore, Integer>{

}
