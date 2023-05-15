package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.SituacaoAprendizagem;

@Repository
public interface SituacaoAprendizagemRepository extends JpaRepository<SituacaoAprendizagem, Integer>{

}
