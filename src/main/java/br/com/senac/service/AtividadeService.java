package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Atividade;
import br.com.senac.model.dtos.AtividadeDTO;
import br.com.senac.repository.AtividadeRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public AtividadeDTO adicionar(AtividadeDTO atividadeDto) {
		atividadeDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Atividade atividade = mapper.map(atividadeDto, Atividade.class);
		atividade = atividadeRepository.save(atividade);
		atividadeDto.setId(atividade.getId());
		return atividadeDto;
	}
	
	public List<AtividadeDTO> obterTodos(){
		List<Atividade> atividades = atividadeRepository.findAll();
		return atividades.stream().map(atividade -> new ModelMapper().map(atividade, AtividadeDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<AtividadeDTO> obterPorId(Integer id){
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		
		if(atividade.isEmpty()) {
			throw new ObjectnotFoundException("ATIVIDADE COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		AtividadeDTO dto = new ModelMapper().map(atividade.get(), AtividadeDTO.class);
		return Optional.of(dto);
	}
	
	public AtividadeDTO atualizar(Integer id, AtividadeDTO atividadeDto) {
		Optional<Atividade> atividadeId = atividadeRepository.findById(id);
		
		if(atividadeId.isEmpty()) {
			throw new ObjectnotFoundException("ATIVIDADE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		atividadeDto.setId(id);
		atividadeDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Atividade atividade = mapper.map(atividadeDto, Atividade.class);
		atividadeRepository.save(atividade);
		return atividadeDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		
		if(atividade.isEmpty()) {
			throw new ObjectnotFoundException("ATIVIDADE COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		atividadeRepository.deleteById(id);
	}
}
