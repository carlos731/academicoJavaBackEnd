package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer>{

}
