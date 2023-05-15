package br.com.senac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.model.ArquivoTeste;

@Repository
public interface ArquivoTesteRepository extends JpaRepository<ArquivoTeste, Integer>{
	
	@Query(value = "SELECT * FROM arquivo_teste", nativeQuery = true)
	List<ArquivoTeste> buscarTodosArquivos();

	@Query(value = "SELECT * FROM arquivo_teste WHERE arquivo_id = :id AND arquivo_status >= 0", nativeQuery = true)
	Optional<ArquivoTeste> buscarArquivoAtivosPorId(Integer id); 
 
}
