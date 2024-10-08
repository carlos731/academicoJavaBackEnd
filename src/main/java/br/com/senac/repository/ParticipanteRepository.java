package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer>{

}
