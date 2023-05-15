package br.com.senac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer>{
	
	@Query(value = "SELECT * FROM arquivo", nativeQuery = true)
	List<Arquivo> buscarTodosArquivos();

	@Query(value = "SELECT * FROM arquivo WHERE arquivo_id = :id AND arquivo_status >= 0", nativeQuery = true)
	Optional<Arquivo> buscarArquivoAtivosPorId(Integer id); 
}
