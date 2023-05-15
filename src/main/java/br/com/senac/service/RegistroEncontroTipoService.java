package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.RegistroEncontroTipo;
import br.com.senac.model.dtos.RegistroEncontroTipoDTO;
import br.com.senac.repository.RegistroEncontroTipoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class RegistroEncontroTipoService {

	@Autowired
	private RegistroEncontroTipoRepository registroEncontroTipoRepository;
	
	public RegistroEncontroTipoDTO adicionar(RegistroEncontroTipoDTO registroEncontroTipoDto) {
		registroEncontroTipoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		RegistroEncontroTipo registroEncontroTipo = mapper.map(registroEncontroTipoDto, RegistroEncontroTipo.class);
		registroEncontroTipo = registroEncontroTipoRepository.save(registroEncontroTipo);
		registroEncontroTipoDto.setId(registroEncontroTipo.getId());
		return registroEncontroTipoDto;
	}
	
	public List<RegistroEncontroTipoDTO> obterTodos(){
		List<RegistroEncontroTipo> registroEncontroTipos = registroEncontroTipoRepository.findAll();
		return registroEncontroTipos.stream().map(registroEncontroTipo -> new ModelMapper().map(registroEncontroTipo, RegistroEncontroTipoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<RegistroEncontroTipoDTO> obterPorId(Integer id){
		Optional<RegistroEncontroTipo> registroEncontroTipo = registroEncontroTipoRepository.findById(id);
		
		if(registroEncontroTipo.isEmpty()) {
			throw new ObjectnotFoundException("REGISTRO TIPO ENCONTRO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		RegistroEncontroTipoDTO dto = new ModelMapper().map(registroEncontroTipo.get(), RegistroEncontroTipoDTO.class);
		return Optional.of(dto);
	}
	
	public RegistroEncontroTipoDTO atualizar(Integer id, RegistroEncontroTipoDTO registroEncontroTipoDto) {
		Optional<RegistroEncontroTipo> registroEncontroTipoId = registroEncontroTipoRepository.findById(id);
		
		if(registroEncontroTipoId.isEmpty()) {
			throw new ObjectnotFoundException("REGISTRO TIPO ENCONTRO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		registroEncontroTipoDto.setId(id);
		registroEncontroTipoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		RegistroEncontroTipo registroEncontroTipo = mapper.map(registroEncontroTipoDto, RegistroEncontroTipo.class);
		registroEncontroTipoRepository.save(registroEncontroTipo);
		return registroEncontroTipoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<RegistroEncontroTipo> registroEncontroTipo = registroEncontroTipoRepository.findById(id);
		
		if(registroEncontroTipo.isEmpty()) {
			throw new ObjectnotFoundException("REGISTRO TIPO ENCONTRO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		registroEncontroTipoRepository.deleteById(id);
	}
}
