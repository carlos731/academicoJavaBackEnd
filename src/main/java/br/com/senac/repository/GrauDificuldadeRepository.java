package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.GrauDificuldade;

@Repository
public interface GrauDificuldadeRepository extends JpaRepository<GrauDificuldade, Integer>{

}
