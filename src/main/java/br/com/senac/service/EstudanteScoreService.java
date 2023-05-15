package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.EstudanteScore;
import br.com.senac.model.dtos.EstudanteScoreDTO;
import br.com.senac.repository.EstudanteScoreRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class EstudanteScoreService {

	@Autowired
	private EstudanteScoreRepository estudanteScoreRepository;
	
	public EstudanteScoreDTO adicionar(EstudanteScoreDTO estudanteScoreDto) {
		estudanteScoreDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		EstudanteScore estudanteScore = mapper.map(estudanteScoreDto, EstudanteScore.class);
		estudanteScore = estudanteScoreRepository.save(estudanteScore);
		estudanteScoreDto.setId(estudanteScore.getId());
		return estudanteScoreDto;
	}
	
	public List<EstudanteScoreDTO> obterTodos(){
		List<EstudanteScore> estudanteScores = estudanteScoreRepository.findAll();
		return estudanteScores.stream().map(estudanteScore -> new ModelMapper().map(estudanteScore, EstudanteScoreDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<EstudanteScoreDTO> obterPorId(Integer id){
		Optional<EstudanteScore> estudanteScore = estudanteScoreRepository.findById(id);
		
		if(estudanteScore.isEmpty()) {
			throw new ObjectnotFoundException("PONTUAÇÃO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		EstudanteScoreDTO dto = new ModelMapper().map(estudanteScore.get(), EstudanteScoreDTO.class);
		return Optional.of(dto);
	}
	
	public EstudanteScoreDTO atualizar(Integer id, EstudanteScoreDTO estudanteScoreDto) {
		Optional<EstudanteScore> estudanteScoreId = estudanteScoreRepository.findById(id);
		
		if(estudanteScoreId.isEmpty()) {
			throw new ObjectnotFoundException("PONTUAÇÃO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		estudanteScoreDto.setId(id);
		estudanteScoreDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		EstudanteScore estudanteScore = mapper.map(estudanteScoreDto, EstudanteScore.class);
		estudanteScoreRepository.save(estudanteScore);
		return estudanteScoreDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<EstudanteScore> estudanteScore = estudanteScoreRepository.findById(id);
		
		if(estudanteScore.isEmpty()) {
			throw new ObjectnotFoundException("PONTUAÇÃO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		estudanteScoreRepository.deleteById(id);
	}
}
