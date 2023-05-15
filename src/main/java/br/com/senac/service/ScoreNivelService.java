package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.ScoreNivel;
import br.com.senac.model.dtos.ScoreNivelDTO;
import br.com.senac.repository.ScoreNivelRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ScoreNivelService {

	@Autowired
	private ScoreNivelRepository scoreNivelRepository;
	
	public ScoreNivelDTO adicionar(ScoreNivelDTO scoreNivelDto) {
		scoreNivelDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		ScoreNivel scoreNivel = mapper.map(scoreNivelDto, ScoreNivel.class);
		scoreNivel = scoreNivelRepository.save(scoreNivel);
		scoreNivelDto.setId(scoreNivel.getId());
		return scoreNivelDto;
	}
	
	public List<ScoreNivelDTO> obterTodos(){
		List<ScoreNivel> scoreNivels = scoreNivelRepository.findAll();
		return scoreNivels.stream().map(scoreNivel -> new ModelMapper().map(scoreNivel, ScoreNivelDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<ScoreNivelDTO> obterPorId(Integer id){
		Optional<ScoreNivel> scoreNivel = scoreNivelRepository.findById(id);
		
		if(scoreNivel.isEmpty()) {
			throw new ObjectnotFoundException("SCORE_NIVEL COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		ScoreNivelDTO dto = new ModelMapper().map(scoreNivel.get(), ScoreNivelDTO.class);
		return Optional.of(dto);
	}
	
	public ScoreNivelDTO atualizar(Integer id, ScoreNivelDTO scoreNivelDto) {
		Optional<ScoreNivel> scoreNivelId = scoreNivelRepository.findById(id);
		
		if(scoreNivelId.isEmpty()) {
			throw new ObjectnotFoundException("SCORE_NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		scoreNivelDto.setId(id);
		scoreNivelDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		ScoreNivel scoreNivel = mapper.map(scoreNivelDto, ScoreNivel.class);
		scoreNivelRepository.save(scoreNivel);
		return scoreNivelDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<ScoreNivel> scoreNivel = scoreNivelRepository.findById(id);
		
		if(scoreNivel.isEmpty()) {
			throw new ObjectnotFoundException("SCORE_NIVEL COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		scoreNivelRepository.deleteById(id);
	}
}
