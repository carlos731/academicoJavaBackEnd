package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.CursoTipo;

@Repository
public interface CursoTipoRepository extends JpaRepository<CursoTipo, Integer>{

}
