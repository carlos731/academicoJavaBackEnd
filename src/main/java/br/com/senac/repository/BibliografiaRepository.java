package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Bibliografia;

@Repository
public interface BibliografiaRepository extends JpaRepository<Bibliografia, Integer>{

}
