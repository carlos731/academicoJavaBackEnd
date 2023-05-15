package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.EncontroTipo;
import br.com.senac.model.dtos.EncontroTipoDTO;
import br.com.senac.repository.EncontroTipoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class EncontroTipoService {

	@Autowired
	private EncontroTipoRepository encontroTipoRepository;
	
	public EncontroTipoDTO adicionar(EncontroTipoDTO encontroTipoDto) {
		encontroTipoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		EncontroTipo encontroTipo = mapper.map(encontroTipoDto, EncontroTipo.class);
		encontroTipo = encontroTipoRepository.save(encontroTipo);
		encontroTipoDto.setId(encontroTipo.getId());
		return encontroTipoDto;
	}
	
	public List<EncontroTipoDTO> obterTodos(){
		List<EncontroTipo> encontroTipos = encontroTipoRepository.findAll();
		return encontroTipos.stream().map(encontroTipo -> new ModelMapper().map(encontroTipo, EncontroTipoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<EncontroTipoDTO> obterPorId(Integer id){
		Optional<EncontroTipo> encontroTipo = encontroTipoRepository.findById(id);
		
		if(encontroTipo.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO TIPO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		EncontroTipoDTO dto = new ModelMapper().map(encontroTipo.get(), EncontroTipoDTO.class);
		return Optional.of(dto);
	}
	
	public EncontroTipoDTO atualizar(Integer id, EncontroTipoDTO encontroTipoDto) {
		Optional<EncontroTipo> encontroTipoId = encontroTipoRepository.findById(id);
		
		if(encontroTipoId.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO TIPO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		encontroTipoDto.setId(id);
		encontroTipoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		EncontroTipo encontroTipo = mapper.map(encontroTipoDto, EncontroTipo.class);
		encontroTipoRepository.save(encontroTipo);
		return encontroTipoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<EncontroTipo> encontroTipo = encontroTipoRepository.findById(id);
		
		if(encontroTipo.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO TIPO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		encontroTipoRepository.deleteById(id);
	}
}
