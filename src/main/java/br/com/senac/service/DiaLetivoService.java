package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.DiaLetivo;
import br.com.senac.model.dtos.DiaLetivoDTO;
import br.com.senac.repository.DiaLetivoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class DiaLetivoService {

	@Autowired
	private DiaLetivoRepository diaLetivoRepository;
	
	public DiaLetivoDTO adicionar(DiaLetivoDTO diaLetivoDto) {
		diaLetivoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		DiaLetivo diaLetivo = mapper.map(diaLetivoDto, DiaLetivo.class);
		diaLetivo = diaLetivoRepository.save(diaLetivo);
		diaLetivoDto.setId(diaLetivo.getId());
		return diaLetivoDto;
	}
	
	public List<DiaLetivoDTO> obterTodos(){
		List<DiaLetivo> diaLetivos = diaLetivoRepository.findAll();
		return diaLetivos.stream().map(diaLetivo -> new ModelMapper().map(diaLetivo, DiaLetivoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<DiaLetivoDTO> obterPorId(Integer id){
		Optional<DiaLetivo> diaLetivo = diaLetivoRepository.findById(id);
		
		if(diaLetivo.isEmpty()) {
			throw new ObjectnotFoundException("DIA LETIVO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		DiaLetivoDTO dto = new ModelMapper().map(diaLetivo.get(), DiaLetivoDTO.class);
		return Optional.of(dto);
	}
	
	public DiaLetivoDTO atualizar(Integer id, DiaLetivoDTO diaLetivoDto) {
		Optional<DiaLetivo> diaLetivoId = diaLetivoRepository.findById(id);
		
		if(diaLetivoId.isEmpty()) {
			throw new ObjectnotFoundException("DIA LETIVO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		diaLetivoDto.setId(id);
		diaLetivoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		DiaLetivo diaLetivo = mapper.map(diaLetivoDto, DiaLetivo.class);
		diaLetivoRepository.save(diaLetivo);
		return diaLetivoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<DiaLetivo> diaLetivo = diaLetivoRepository.findById(id);
		
		if(diaLetivo.isEmpty()) {
			throw new ObjectnotFoundException("DIA LETIVO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		diaLetivoRepository.deleteById(id);
	}
}
