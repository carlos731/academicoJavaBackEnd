package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.RegistroEncontroTipo;

@Repository
public interface RegistroEncontroTipoRepository extends JpaRepository<RegistroEncontroTipo, Integer>{

}
