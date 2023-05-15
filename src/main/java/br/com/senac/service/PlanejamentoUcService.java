package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.PlanejamentoUc;
import br.com.senac.model.dtos.PlanejamentoUcDTO;
import br.com.senac.repository.PlanejamentoUcRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class PlanejamentoUcService {

	@Autowired
	private PlanejamentoUcRepository planejamentoUcRepository;
	
	public PlanejamentoUcDTO adicionar(PlanejamentoUcDTO planejamentoUcDto) {
		planejamentoUcDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		PlanejamentoUc planejamentoUc = mapper.map(planejamentoUcDto, PlanejamentoUc.class);
		planejamentoUc = planejamentoUcRepository.save(planejamentoUc);
		planejamentoUcDto.setId(planejamentoUc.getId());
		return planejamentoUcDto;
	}
	
	public List<PlanejamentoUcDTO> obterTodos(){
		List<PlanejamentoUc> planejamentoUcs = planejamentoUcRepository.findAll();
		return planejamentoUcs.stream().map(planejamentoUc -> new ModelMapper().map(planejamentoUc, PlanejamentoUcDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<PlanejamentoUcDTO> obterPorId(Integer id){
		Optional<PlanejamentoUc> planejamentoUc = planejamentoUcRepository.findById(id);
		
		if(planejamentoUc.isEmpty()) {
			throw new ObjectnotFoundException("PlanejamentoUC COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		PlanejamentoUcDTO dto = new ModelMapper().map(planejamentoUc.get(), PlanejamentoUcDTO.class);
		return Optional.of(dto);
	}
	
	public PlanejamentoUcDTO atualizar(Integer id, PlanejamentoUcDTO planejamentoUcDto) {
		Optional<PlanejamentoUc> planejamentoUcId = planejamentoUcRepository.findById(id);
		
		if(planejamentoUcId.isEmpty()) {
			throw new ObjectnotFoundException("PlanejamentoUC COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		planejamentoUcDto.setId(id);
		planejamentoUcDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		PlanejamentoUc planejamentoUc = mapper.map(planejamentoUcDto, PlanejamentoUc.class);
		planejamentoUcRepository.save(planejamentoUc);
		return planejamentoUcDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<PlanejamentoUc> planejamentoUc = planejamentoUcRepository.findById(id);
		
		if(planejamentoUc.isEmpty()) {
			throw new ObjectnotFoundException("PlanejamentoUC COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		planejamentoUcRepository.deleteById(id);
	}
}
