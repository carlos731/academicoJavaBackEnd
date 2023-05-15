package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{

}
