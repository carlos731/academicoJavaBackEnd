package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Curso;
import br.com.senac.model.Enums.CursoStatus;
import br.com.senac.model.dtos.CursoDTO;
import br.com.senac.repository.CursoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public CursoDTO adicionar(CursoDTO cursoDto) {
		cursoDto.setId(null);
		cursoDto.setStatus(CursoStatus.INATIVO);
		ModelMapper mapper = new ModelMapper();
		Curso curso = mapper.map(cursoDto, Curso.class);
		curso = cursoRepository.save(curso);
		cursoDto.setId(curso.getId());
		return cursoDto;
	}
	
	public List<CursoDTO> obterTodos(){
		List<Curso> cursos = cursoRepository.findAll();
		return cursos.stream().map(curso -> new ModelMapper().map(curso, CursoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<CursoDTO> obterPorId(Integer id){
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if(curso.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		CursoDTO dto = new ModelMapper().map(curso.get(), CursoDTO.class);
		return Optional.of(dto);
	}
	
	public CursoDTO atualizar(Integer id, CursoDTO cursoDto) {
		Optional<Curso> cursoId = cursoRepository.findById(id);
		
		if(cursoId.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		cursoDto.setId(id);
		cursoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Curso curso = mapper.map(cursoDto, Curso.class);
		cursoRepository.save(curso);
		return cursoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if(curso.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		cursoRepository.deleteById(id);
	}
	
	public List<Curso> findByCursosAtivos(){
		return cursoRepository.findByCursosAtivos();
	}
}
