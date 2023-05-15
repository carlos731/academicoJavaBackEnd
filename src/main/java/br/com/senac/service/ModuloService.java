package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Modulo;
import br.com.senac.model.dtos.ModuloDTO;
import br.com.senac.repository.ModuloRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ModuloService {

	@Autowired 
	private ModuloRepository moduloRepository;
	
	public ModuloDTO adicionar(ModuloDTO moduloDto) {
		moduloDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Modulo modulo = mapper.map(moduloDto, Modulo.class);
		modulo = moduloRepository.save(modulo);
		moduloDto.setId(modulo.getId());
		return moduloDto;
	}
	
	public List<ModuloDTO> obterTodos(){
		List<Modulo> modulos = moduloRepository.findAll();
		return modulos.stream().map(modulo -> new ModelMapper().map(modulo, ModuloDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<ModuloDTO> obterPorId(Integer id){
		Optional<Modulo> modulo = moduloRepository.findById(id);
		
		if(modulo.isEmpty()) {
			throw new ObjectnotFoundException("MODULO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		ModuloDTO dto = new ModelMapper().map(modulo.get(), ModuloDTO.class);
		return Optional.of(dto);
	}
	
	public ModuloDTO atualizar(Integer id, ModuloDTO moduloDto) {
		Optional<Modulo> moduloId = moduloRepository.findById(id);
		
		if(moduloId.isEmpty()) {
			throw new ObjectnotFoundException("MODULO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		moduloDto.setId(id);
		moduloDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Modulo modulo = mapper.map(moduloDto, Modulo.class);
		moduloRepository.save(modulo);
		return moduloDto;
	}
	
	public void deletar(Integer id) {
		Optional<Modulo> modulo = moduloRepository.findById(id);
		
		if(modulo.isEmpty()) {
			throw new ObjectnotFoundException("MODULO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		moduloRepository.deleteById(id);
	}
	
}	
