package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.CopetenciaIndicador;
import br.com.senac.model.dtos.CopetenciaIndicadorDTO;
import br.com.senac.repository.CopetenciaIndicadorRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class CopetenciaIndicadorService {

	@Autowired 
	private CopetenciaIndicadorRepository copetenciaIndicadorRepository;
	
	public CopetenciaIndicadorDTO adicionar(CopetenciaIndicadorDTO copetenciaIndicadorDto) {
		copetenciaIndicadorDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		CopetenciaIndicador copetenciaIndicador = mapper.map(copetenciaIndicadorDto, CopetenciaIndicador.class);
		copetenciaIndicador = copetenciaIndicadorRepository.save(copetenciaIndicador);
		copetenciaIndicadorDto.setId(copetenciaIndicador.getId());
		return copetenciaIndicadorDto;
	}
	
	public List<CopetenciaIndicadorDTO> obterTodos(){
		List<CopetenciaIndicador> copetenciaIndicadores = copetenciaIndicadorRepository.findAll();
		return copetenciaIndicadores.stream().map(copetenciaIndicador -> new ModelMapper().map(copetenciaIndicador, CopetenciaIndicadorDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<CopetenciaIndicadorDTO> obterPorId(Integer id){
		Optional<CopetenciaIndicador> copetenciaIndicador = copetenciaIndicadorRepository.findById(id);
		
		if(copetenciaIndicador.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		CopetenciaIndicadorDTO dto = new ModelMapper().map(copetenciaIndicador.get(), CopetenciaIndicadorDTO.class);
		return Optional.of(dto);
	}
	
	public CopetenciaIndicadorDTO atualizar(Integer id, CopetenciaIndicadorDTO copetenciaIndicadorDto) {
		Optional<CopetenciaIndicador> copetenciaIndicadorId = copetenciaIndicadorRepository.findById(id);
		
		if(copetenciaIndicadorId.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		copetenciaIndicadorDto.setId(id);
		copetenciaIndicadorDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		CopetenciaIndicador copetenciaIndicador = mapper.map(copetenciaIndicadorDto, CopetenciaIndicador.class);
		copetenciaIndicadorRepository.save(copetenciaIndicador);
		return copetenciaIndicadorDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<CopetenciaIndicador> copetenciaIndicador = copetenciaIndicadorRepository.findById(id);
		
		if(copetenciaIndicador.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		copetenciaIndicadorRepository.deleteById(id);
	}
}
