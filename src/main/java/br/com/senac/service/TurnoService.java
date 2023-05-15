package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Turno;
import br.com.senac.model.dtos.TurnoDTO;
import br.com.senac.repository.TurnoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class TurnoService {

	@Autowired
	private TurnoRepository turnoRepository;
	
	public TurnoDTO adicionar(TurnoDTO turnoDto) {
		turnoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Turno turno = mapper.map(turnoDto, Turno.class);
		turno = turnoRepository.save(turno);
		turnoDto.setId(turno.getId());
		return turnoDto;
	}
	
	public List<TurnoDTO> obterTodos(){
		List<Turno> turnos = turnoRepository.findAll();
		return turnos.stream().map(turno -> new ModelMapper().map(turno, TurnoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<TurnoDTO> obterPorId(Integer id){
		Optional<Turno> turno = turnoRepository.findById(id);
		
		if(turno.isEmpty()) {
			throw new ObjectnotFoundException("TURNO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		TurnoDTO dto = new ModelMapper().map(turno.get(), TurnoDTO.class);
		return Optional.of(dto);
	}
	
	public TurnoDTO atualizar(Integer id, TurnoDTO turnoDto) {
		Optional<Turno> turnoId = turnoRepository.findById(id);
		
		if(turnoId.isEmpty()) {
			throw new ObjectnotFoundException("TURNO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		turnoDto.setId(id);
		turnoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Turno turno = mapper.map(turnoDto, Turno.class);
		turnoRepository.save(turno);
		return turnoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Turno> turno = turnoRepository.findById(id);
		
		if(turno.isEmpty()) {
			throw new ObjectnotFoundException("TURNO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		turnoRepository.deleteById(id);
	}
	
}
