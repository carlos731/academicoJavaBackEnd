package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Participante;
import br.com.senac.model.dtos.ParticipanteDTO;
import br.com.senac.repository.ParticipanteRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public ParticipanteDTO adicionar(ParticipanteDTO participanteDto) {
		participanteDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Participante participante = mapper.map(participanteDto, Participante.class);
		participante = participanteRepository.save(participante);
		participanteDto.setId(participante.getId());
		return participanteDto;
	}
	
	public List<ParticipanteDTO> obterTodos(){
		List<Participante> participantes = participanteRepository.findAll();
		return participantes.stream().map(participante -> new ModelMapper().map(participante, ParticipanteDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<ParticipanteDTO> obterPorId(Integer id){
		Optional<Participante> participante = participanteRepository.findById(id);
		
		if(participante.isEmpty()) {
			throw new ObjectnotFoundException("PARTICIPANTE COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		ParticipanteDTO dto = new ModelMapper().map(participante.get(), ParticipanteDTO.class);
		return Optional.of(dto);
	}
	
	public ParticipanteDTO atualizar(Integer id, ParticipanteDTO participanteDto) {
		Optional<Participante> participanteId = participanteRepository.findById(id);
		
		if(participanteId.isEmpty()) {
			throw new ObjectnotFoundException("PARTICIPANTE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		participanteDto.setId(id);
		participanteDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Participante participante = mapper.map(participanteDto, Participante.class);
		participanteRepository.save(participante);
		return participanteDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Participante> participante = participanteRepository.findById(id);
		
		if(participante.isEmpty()) {
			throw new ObjectnotFoundException("PARTICIPANTE COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		participanteRepository.deleteById(id);
	}
}
