package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.RegistroAvaliacao;

@Repository
public interface RegistroAvaliacaoRepository extends JpaRepository<RegistroAvaliacao, Integer>{

}
