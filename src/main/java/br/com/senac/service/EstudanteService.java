package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Estudante;
import br.com.senac.model.dtos.EstudanteDTO;
import br.com.senac.repository.EstudanteRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class EstudanteService {

	@Autowired 
	private EstudanteRepository estudanteRepository;
	
	public EstudanteDTO adicionar(EstudanteDTO estudanteDto) {
		estudanteDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Estudante estudante = mapper.map(estudanteDto, Estudante.class);
		estudante = estudanteRepository.save(estudante);
		estudanteDto.setId(estudante.getId());
		return estudanteDto;
	}
	
	public List<EstudanteDTO> obterTodos(){
		List<Estudante> estudantes = estudanteRepository.findAll();
		return estudantes.stream().map(estudante -> new ModelMapper().map(estudante, EstudanteDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<EstudanteDTO> obterPorId(Integer id){
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		
		if(estudante.isEmpty()) {
			throw new ObjectnotFoundException("ESTUDANTE COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		EstudanteDTO dto = new ModelMapper().map(estudante.get(), EstudanteDTO.class);
		return Optional.of(dto);
	}
	
	public EstudanteDTO atualizar(Integer id, EstudanteDTO estudanteDto) {
		Optional<Estudante> estudanteId = estudanteRepository.findById(id);
		
		if(estudanteId.isEmpty()) {
			throw new ObjectnotFoundException("ESTUDANTE COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		estudanteDto.setId(id);
		estudanteDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Estudante estudante = mapper.map(estudanteDto, Estudante.class);
		estudanteRepository.save(estudante);
		return estudanteDto;
	}
	
	public void deletar(Integer id) {
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		
		if(estudante.isEmpty()) {
			throw new ObjectnotFoundException("ESTUDANTE COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		estudanteRepository.deleteById(id);
	}
	
}
