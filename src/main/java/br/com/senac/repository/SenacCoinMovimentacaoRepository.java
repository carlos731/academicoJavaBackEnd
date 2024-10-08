package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.SenacCoinMovimentacao;

@Repository
public interface SenacCoinMovimentacaoRepository extends JpaRepository<SenacCoinMovimentacao, Integer>{

}
