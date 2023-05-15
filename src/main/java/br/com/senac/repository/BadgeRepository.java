package br.com.senac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Badge;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer>{

	@Query(value = "SELECT * FROM badge WHERE badge_nivel_id = :id", nativeQuery = true)
	List<Badge> findByNivel(Integer id); 

	Optional<Badge> findByBadgeNivelId(Integer id);
}


