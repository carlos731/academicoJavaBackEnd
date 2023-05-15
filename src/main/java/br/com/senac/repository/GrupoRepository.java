package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer>{

}
