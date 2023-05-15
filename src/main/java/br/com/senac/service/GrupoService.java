package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Grupo;
import br.com.senac.model.dtos.GrupoDTO;
import br.com.senac.repository.GrupoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	public GrupoDTO adicionar(GrupoDTO grupoDto) {
		grupoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Grupo grupo = mapper.map(grupoDto, Grupo.class);
		grupo = grupoRepository.save(grupo);
		grupoDto.setId(grupo.getId());
		return grupoDto;
	}
	
	public List<GrupoDTO> obterTodos(){
		List<Grupo> grupos = grupoRepository.findAll();
		return grupos.stream().map(grupo -> new ModelMapper().map(grupo, GrupoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<GrupoDTO> obterPorId(Integer id){
		Optional<Grupo> grupo = grupoRepository.findById(id);
		
		if(grupo.isEmpty()) {
			throw new ObjectnotFoundException("GRUPO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		GrupoDTO dto = new ModelMapper().map(grupo.get(), GrupoDTO.class);
		return Optional.of(dto);
	}
	
	public GrupoDTO atualizar(Integer id, GrupoDTO grupoDto) {
		Optional<Grupo> grupoId = grupoRepository.findById(id);
		
		if(grupoId.isEmpty()) {
			throw new ObjectnotFoundException("GRUPO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		grupoDto.setId(id);
		grupoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Grupo grupo = mapper.map(grupoDto, Grupo.class);
		grupoRepository.save(grupo);
		return grupoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Grupo> grupo = grupoRepository.findById(id);
		
		if(grupo.isEmpty()) {
			throw new ObjectnotFoundException("GRUPO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		grupoRepository.deleteById(id);
	}
}
