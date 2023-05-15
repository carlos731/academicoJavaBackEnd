package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.DiaLetivo;

@Repository
public interface DiaLetivoRepository extends JpaRepository<DiaLetivo, Integer>{

}
