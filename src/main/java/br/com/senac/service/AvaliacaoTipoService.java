package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.AvaliacaoTipo;
import br.com.senac.model.dtos.AvaliacaoTipoDTO;
import br.com.senac.repository.AvaliacaoTipoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class AvaliacaoTipoService {
	
	@Autowired
	private AvaliacaoTipoRepository avaliacaoTipoRepository;
	
	public AvaliacaoTipoDTO adicionar(AvaliacaoTipoDTO avaliacaoTipoDto) {
		avaliacaoTipoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		AvaliacaoTipo avaliacaoTipo = mapper.map(avaliacaoTipoDto, AvaliacaoTipo.class);
		avaliacaoTipo = avaliacaoTipoRepository.save(avaliacaoTipo);
		avaliacaoTipoDto.setId(avaliacaoTipo.getId());
		return avaliacaoTipoDto;
	}
	
	public List<AvaliacaoTipoDTO> obterTodos(){
		List<AvaliacaoTipo> avaliacaoTipos = avaliacaoTipoRepository.findAll();
		return avaliacaoTipos.stream().map(avaliacaoTipo -> new ModelMapper().map(avaliacaoTipo, AvaliacaoTipoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<AvaliacaoTipoDTO> obterPorId(Integer id){
		Optional<AvaliacaoTipo> avaliacaoTipo = avaliacaoTipoRepository.findById(id);
		
		if(avaliacaoTipo.isEmpty()) {
			throw new ObjectnotFoundException("AVALIACAO TIPO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		AvaliacaoTipoDTO dto = new ModelMapper().map(avaliacaoTipo.get(), AvaliacaoTipoDTO.class);
		return Optional.of(dto);
	}
	
	public AvaliacaoTipoDTO atualizar(Integer id, AvaliacaoTipoDTO avaliacaoTipoDto) {
		Optional<AvaliacaoTipo> avaliacaoTipoId = avaliacaoTipoRepository.findById(id);
		
		if(avaliacaoTipoId.isEmpty()) {
			throw new ObjectnotFoundException("AVALIACAO TIPO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		avaliacaoTipoDto.setId(id);
		avaliacaoTipoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		AvaliacaoTipo avaliacaoTipo = mapper.map(avaliacaoTipoDto, AvaliacaoTipo.class);
		avaliacaoTipoRepository.save(avaliacaoTipo);
		return avaliacaoTipoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<AvaliacaoTipo> avaliacaoTipo = avaliacaoTipoRepository.findById(id);
		
		if(avaliacaoTipo.isEmpty()) {
			throw new ObjectnotFoundException("AVALIACAO TIPO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		avaliacaoTipoRepository.deleteById(id);
	}
}
