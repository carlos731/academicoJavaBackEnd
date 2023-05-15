package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Colaborador;
import br.com.senac.model.dtos.ColaboradorDTO;
import br.com.senac.repository.ColaboradorRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public ColaboradorDTO adicionar(ColaboradorDTO colaboradorDto) {
		colaboradorDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Colaborador colaborador = mapper.map(colaboradorDto, Colaborador.class);
		colaborador = colaboradorRepository.save(colaborador);
		colaboradorDto.setId(colaborador.getId());
		return colaboradorDto;
	}
	
	public List<ColaboradorDTO> obterTodos(){
		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		return colaboradores.stream().map(colaborador -> new ModelMapper().map(colaborador, ColaboradorDTO.class)).collect(Collectors.toList());
	}
	
	public Optional<ColaboradorDTO> obterPorId(Integer id){
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
		
		if(colaborador.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		ColaboradorDTO dto = new ModelMapper().map(colaborador.get(), ColaboradorDTO.class);
		return Optional.of(dto);
		
	}
	
	public ColaboradorDTO atualizar(Integer id, ColaboradorDTO colaboradorDto) {
		Optional<Colaborador> colaboraId = colaboradorRepository.findById(id);
		
		if(colaboraId.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		colaboradorDto.setId(id);
		colaboradorDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Colaborador colaborador = mapper.map(colaboradorDto,  Colaborador.class);
		colaboradorRepository.save(colaborador);
		return colaboradorDto;	
	}
	
	public void deletar(Integer id) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
		
		if(colaborador.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		colaboradorRepository.deleteById(id);
	}
	
}
