package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.GrauDificuldade;
import br.com.senac.model.dtos.GrauDificuldadeDTO;
import br.com.senac.repository.GrauDificuldadeRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class GrauDificuldadeService {

	@Autowired
	private GrauDificuldadeRepository grauDificuldadeRepository;
	
	public GrauDificuldadeDTO adicionar(GrauDificuldadeDTO grauDificuldadeDto) {
		grauDificuldadeDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		GrauDificuldade grauDificuldade = mapper.map(grauDificuldadeDto, GrauDificuldade.class);
		grauDificuldade = grauDificuldadeRepository.save(grauDificuldade);
		grauDificuldadeDto.setId(grauDificuldade.getId());
		return grauDificuldadeDto;
	}
	
	public List<GrauDificuldadeDTO> obterTodos(){
		List<GrauDificuldade> grauDificuldades = grauDificuldadeRepository.findAll();
		return grauDificuldades.stream().map(grauDificuldade -> new ModelMapper().map(grauDificuldade, GrauDificuldadeDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<GrauDificuldadeDTO> obterPorId(Integer id){
		Optional<GrauDificuldade> grauDificuldade = grauDificuldadeRepository.findById(id);
		
		if(grauDificuldade.isEmpty()) {
			throw new ObjectnotFoundException("GRAU DIFICULDADE COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		GrauDificuldadeDTO dto = new ModelMapper().map(grauDificuldade.get(), GrauDificuldadeDTO.class);
		return Optional.of(dto);
	}
	
	public GrauDificuldadeDTO atualizar(Integer id, GrauDificuldadeDTO grauDificuldadeDto) {
		Optional<GrauDificuldade> grauDificuldadeId = grauDificuldadeRepository.findById(id);
		
		if(grauDificuldadeId.isEmpty()) {
			throw new ObjectnotFoundException("GRAU DIFICULDADE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		grauDificuldadeDto.setId(id);
		grauDificuldadeDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		GrauDificuldade grauDificuldade = mapper.map(grauDificuldadeDto, GrauDificuldade.class);
		grauDificuldadeRepository.save(grauDificuldade);
		return grauDificuldadeDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<GrauDificuldade> grauDificuldade = grauDificuldadeRepository.findById(id);
		
		if(grauDificuldade.isEmpty()) {
			throw new ObjectnotFoundException("GRAU DIFICULDADE COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		grauDificuldadeRepository.deleteById(id);
	}
}
