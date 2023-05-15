package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.ObjetoAprendizagem;

@Repository
public interface ObjetoAprendizagemRepository extends JpaRepository<ObjetoAprendizagem, Integer>{

}
