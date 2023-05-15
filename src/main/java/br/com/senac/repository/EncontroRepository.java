package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Encontro;

@Repository
public interface EncontroRepository extends JpaRepository<Encontro, Integer>{

}
