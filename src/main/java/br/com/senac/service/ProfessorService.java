package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Professor;
import br.com.senac.model.Enums.ProfessorStatus;
import br.com.senac.model.dtos.ProfessorDTO;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public ProfessorDTO adicionar(ProfessorDTO professorDto) {
		professorDto.setId(null);
		professorDto.setStatus(ProfessorStatus.INATIVO);
		ModelMapper mapper = new ModelMapper();
		Professor professor = mapper.map(professorDto, Professor.class);
		professor = professorRepository.save(professor);
		professorDto.setId(professor.getId());
		return professorDto;
	}
	
	public List<ProfessorDTO> obterTodos(){
		List<Professor> professores = professorRepository.findAll();
		return professores.stream().map(professor -> new ModelMapper().map(professor, ProfessorDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<ProfessorDTO> obterPorId(Integer id){
		Optional<Professor> professor = professorRepository.findById(id);
		
		if(professor.isEmpty()) {
			throw new ObjectnotFoundException("Professor com id'" + id + "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		ProfessorDTO dto = new ModelMapper().map(professor.get(), ProfessorDTO.class);
		return Optional.of(dto);
	}
	
	public void deletar(Integer id) {
		Optional<Professor> professor = professorRepository.findById(id);

		if(professor.isEmpty()) {
			throw new ObjectnotFoundException("Professor com id'" + id + "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}		
		
		professorRepository.deleteById(id);
	}
	
	public ProfessorDTO atualizar(Integer id, ProfessorDTO professorDto) {
		Optional<Professor> professorId = professorRepository.findById(id);
		
		if(professorId.isEmpty()) {
			throw new ObjectnotFoundException("Professor com id'" + id + "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		professorDto.setId(id);
		professorDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Professor professor = mapper.map(professorDto, Professor.class);
		professorRepository.save(professor);
		return professorDto;
	}
	
}
