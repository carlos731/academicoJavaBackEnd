package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.EncontroTipo;

@Repository
public interface EncontroTipoRepository extends JpaRepository<EncontroTipo, Integer>{

}
