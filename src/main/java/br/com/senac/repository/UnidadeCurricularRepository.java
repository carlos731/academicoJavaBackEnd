package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.UnidadeCurricular;

@Repository
public interface UnidadeCurricularRepository extends JpaRepository<UnidadeCurricular, Integer>{

}
