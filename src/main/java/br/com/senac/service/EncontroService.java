package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Encontro;
import br.com.senac.model.dtos.EncontroDTO;
import br.com.senac.repository.EncontroRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class EncontroService {
	
	@Autowired
	private EncontroRepository encontroRepository;
	
	public EncontroDTO adicionar(EncontroDTO encontroDto) {
		encontroDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Encontro encontro = mapper.map(encontroDto, Encontro.class);
		encontro = encontroRepository.save(encontro);
		encontroDto.setId(encontro.getId());
		return encontroDto;
	}
	
	public List<EncontroDTO> obterTodos(){
		List<Encontro> encontros = encontroRepository.findAll();
		return encontros.stream().map(encontro -> new ModelMapper().map(encontro, EncontroDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<EncontroDTO> obterPorId(Integer id){
		Optional<Encontro> encontro = encontroRepository.findById(id);
		
		if(encontro.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		EncontroDTO dto = new ModelMapper().map(encontro.get(), EncontroDTO.class);
		return Optional.of(dto);
	}
	
	public EncontroDTO atualizar(Integer id, EncontroDTO encontroDto) {
		Optional<Encontro> encontroId = encontroRepository.findById(id);
		
		if(encontroId.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		encontroDto.setId(id);
		encontroDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Encontro encontro = mapper.map(encontroDto, Encontro.class);
		encontroRepository.save(encontro);
		return encontroDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Encontro> encontro = encontroRepository.findById(id);
		
		if(encontro.isEmpty()) {
			throw new ObjectnotFoundException("ENCONTRo COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		encontroRepository.deleteById(id);
	}
}
