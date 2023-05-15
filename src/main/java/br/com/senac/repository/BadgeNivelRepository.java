package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.BadgeNivel;

@Repository
public interface BadgeNivelRepository extends JpaRepository<BadgeNivel, Integer>{

}
