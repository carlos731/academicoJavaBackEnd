package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.SenacCoin;

@Repository
public interface SenacCoinRepository extends JpaRepository<SenacCoin, Integer> {
	
}
