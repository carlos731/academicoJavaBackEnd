package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.AvaliacaoConceito;

@Repository
public interface AvaliacaoConceitoRepository extends JpaRepository<AvaliacaoConceito, Integer>{

}
