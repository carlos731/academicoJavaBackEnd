package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.BadgeNivel;
import br.com.senac.model.dtos.BadgeNivelDTO;
import br.com.senac.repository.BadgeNivelRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class BadgeNivelService {

	@Autowired
	private BadgeNivelRepository badgeNivelRepository;
	
	public BadgeNivelDTO adicionar(BadgeNivelDTO badgeNivelDto) {
		badgeNivelDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		BadgeNivel badgeNivel = mapper.map(badgeNivelDto, BadgeNivel.class);
		badgeNivel = badgeNivelRepository.save(badgeNivel);
		badgeNivelDto.setId(badgeNivel.getId());
		return badgeNivelDto;
	}
	
	public List<BadgeNivelDTO> obterTodos(){
		List<BadgeNivel> badgeNiveis = badgeNivelRepository.findAll();
		return badgeNiveis.stream().map(badgeNivel -> new ModelMapper().map(badgeNivel, BadgeNivelDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<BadgeNivelDTO> obterPorId(Integer id){
		Optional<BadgeNivel> badgeNivel = badgeNivelRepository.findById(id);
		
		if(badgeNivel.isEmpty()) {
			throw new ObjectnotFoundException("BADGE NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		BadgeNivelDTO dto = new ModelMapper().map(badgeNivel.get(), BadgeNivelDTO.class);
		return Optional.of(dto);
	}
	
	public void deletar(Integer id) {
		Optional<BadgeNivel> badgeNivel = badgeNivelRepository.findById(id);
		
		if(badgeNivel.isEmpty()) {
			throw new ObjectnotFoundException("BADGE NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		badgeNivelRepository.deleteById(id);
	}
	
	public BadgeNivelDTO atualizar(Integer id, BadgeNivelDTO badgeNivelDto) {
		Optional<BadgeNivel> badgeNivelId = badgeNivelRepository.findById(id);
		
		if(badgeNivelId.isEmpty()) {
			throw new ObjectnotFoundException("BADGE NIVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		badgeNivelDto.setId(id);
		badgeNivelDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		BadgeNivel badgeNivel = mapper.map(badgeNivelDto, BadgeNivel.class);
		badgeNivelRepository.save(badgeNivel);
		return badgeNivelDto;
	}
	
}
