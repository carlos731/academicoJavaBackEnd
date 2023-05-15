package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.AtividadeTipo;
import br.com.senac.model.dtos.AtividadeTipoDTO;
import br.com.senac.repository.AtividadeTipoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class AtividadeTipoService {

	@Autowired
	private AtividadeTipoRepository atividadeTipoRepository;
	
	public AtividadeTipoDTO adicionar(AtividadeTipoDTO atividadeTipoDto) {
		atividadeTipoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		AtividadeTipo atividadeTipo = mapper.map(atividadeTipoDto, AtividadeTipo.class);
		atividadeTipo = atividadeTipoRepository.save(atividadeTipo);
		atividadeTipoDto.setId(atividadeTipo.getId());
		return atividadeTipoDto;
	}
	
	public List<AtividadeTipoDTO> obterTodos(){
		List<AtividadeTipo> atividadeTipos = atividadeTipoRepository.findAll();
		return atividadeTipos.stream().map(atividadeTipo -> new ModelMapper().map(atividadeTipo, AtividadeTipoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<AtividadeTipoDTO> obterPorId(Integer id){
		Optional<AtividadeTipo> atividadeTipo = atividadeTipoRepository.findById(id);
		
		if(atividadeTipo.isEmpty()) {
			throw new ObjectnotFoundException("ATIVIDADE TIPO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		AtividadeTipoDTO dto = new ModelMapper().map(atividadeTipo.get(), AtividadeTipoDTO.class);
		return Optional.of(dto);
	}
	
	public AtividadeTipoDTO atualizar(Integer id, AtividadeTipoDTO atividadeTipoDto) {
		Optional<AtividadeTipo> atividadeTipoId = atividadeTipoRepository.findById(id);
		
		if(atividadeTipoId.isEmpty()) {
			throw new ObjectnotFoundException("ATIVIDADE TIPO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		atividadeTipoDto.setId(id);
		atividadeTipoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		AtividadeTipo atividadeTipo = mapper.map(atividadeTipoDto, AtividadeTipo.class);
		atividadeTipoRepository.save(atividadeTipo);
		return atividadeTipoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<AtividadeTipo> atividadeTipo = atividadeTipoRepository.findById(id);
		
		if(atividadeTipo.isEmpty()) {
			throw new ObjectnotFoundException("ATIVIDADE TIPO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		atividadeTipoRepository.deleteById(id);
	}
}
