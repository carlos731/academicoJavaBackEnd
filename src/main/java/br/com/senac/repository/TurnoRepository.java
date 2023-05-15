package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer>{

}
