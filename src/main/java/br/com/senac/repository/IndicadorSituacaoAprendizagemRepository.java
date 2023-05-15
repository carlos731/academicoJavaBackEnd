package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.IndicadorSituacaoAprendizagem;

@Repository
public interface IndicadorSituacaoAprendizagemRepository extends JpaRepository<IndicadorSituacaoAprendizagem, Integer>{

}
