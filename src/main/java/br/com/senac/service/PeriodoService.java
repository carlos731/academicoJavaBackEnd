package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Periodo;
import br.com.senac.model.dtos.PeriodoDTO;
import br.com.senac.repository.PeriodoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class PeriodoService {

	@Autowired 
	private PeriodoRepository periodoRepository;
	
	public PeriodoDTO adicionar(PeriodoDTO periodoDto) {
		periodoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Periodo periodo = mapper.map(periodoDto, Periodo.class);
		periodo = periodoRepository.save(periodo);
		periodoDto.setId(periodo.getId());
		return periodoDto;
	}
	
	public List<PeriodoDTO> obterTodos(){
		List<Periodo> periodos = periodoRepository.findAll();
		return periodos.stream().map(periodo -> new ModelMapper().map(periodo, PeriodoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<PeriodoDTO> obterPorId(Integer id){
		Optional<Periodo> periodo = periodoRepository.findById(id);
		
		if(periodo.isEmpty()) {
			throw new ObjectnotFoundException("PERIODO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		PeriodoDTO dto = new ModelMapper().map(periodo.get(), PeriodoDTO.class);
		return Optional.of(dto);
	}
	
	public PeriodoDTO atualizar(Integer id, PeriodoDTO periodoDto) {
		Optional<Periodo> periodoId = periodoRepository.findById(id);
		
		if(periodoId.isEmpty()) {
			throw new ObjectnotFoundException("PERIODO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		periodoDto.setId(id);
		periodoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Periodo periodo = mapper.map(periodoDto, Periodo.class);
		periodoRepository.save(periodo);
		return periodoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Periodo> periodo = periodoRepository.findById(id);
		
		if(periodo.isEmpty()) {
			throw new ObjectnotFoundException("PERIODO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		periodoRepository.deleteById(id);
	}
}
