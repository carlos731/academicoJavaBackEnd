package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.IndicadorSituacaoAprendizagem;
import br.com.senac.model.dtos.IndicadorSituacaoAprendizagemDTO;
import br.com.senac.repository.IndicadorSituacaoAprendizagemRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class IndicadorSituacaoAprendizagemService {
	
	@Autowired
	private IndicadorSituacaoAprendizagemRepository indicadorSituacaoAprendizagemRepository;
	
	public IndicadorSituacaoAprendizagemDTO adicionar(IndicadorSituacaoAprendizagemDTO indicadorSituacaoAprendizagemDto) {
		indicadorSituacaoAprendizagemDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		IndicadorSituacaoAprendizagem indicadorSituacaoAprendizagem = mapper.map(indicadorSituacaoAprendizagemDto, IndicadorSituacaoAprendizagem.class);
		indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemRepository.save(indicadorSituacaoAprendizagem);
		indicadorSituacaoAprendizagemDto.setId(indicadorSituacaoAprendizagem.getId());
		return indicadorSituacaoAprendizagemDto;
	}
	
	public List<IndicadorSituacaoAprendizagemDTO> obterTodos(){
		List<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagems = indicadorSituacaoAprendizagemRepository.findAll();
		return indicadorSituacaoAprendizagems.stream().map(indicadorSituacaoAprendizagem -> new ModelMapper().map(indicadorSituacaoAprendizagem, IndicadorSituacaoAprendizagemDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<IndicadorSituacaoAprendizagemDTO> obterPorId(Integer id){
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemRepository.findById(id);
		
		if(indicadorSituacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("INDICADOR SITUACAO APRENDIZAGEM COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		IndicadorSituacaoAprendizagemDTO dto = new ModelMapper().map(indicadorSituacaoAprendizagem.get(), IndicadorSituacaoAprendizagemDTO.class);
		return Optional.of(dto);
	}
	
	public IndicadorSituacaoAprendizagemDTO atualizar(Integer id, IndicadorSituacaoAprendizagemDTO indicadorSituacaoAprendizagemDto) {
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagemId = indicadorSituacaoAprendizagemRepository.findById(id);
		
		if(indicadorSituacaoAprendizagemId.isEmpty()) {
			throw new ObjectnotFoundException("INDICADOR SITUACAO APRENDIZAGEM COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		indicadorSituacaoAprendizagemDto.setId(id);
		indicadorSituacaoAprendizagemDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		IndicadorSituacaoAprendizagem indicadorSituacaoAprendizagem = mapper.map(indicadorSituacaoAprendizagemDto, IndicadorSituacaoAprendizagem.class);
		indicadorSituacaoAprendizagemRepository.save(indicadorSituacaoAprendizagem);
		return indicadorSituacaoAprendizagemDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<IndicadorSituacaoAprendizagem> indicadorSituacaoAprendizagem = indicadorSituacaoAprendizagemRepository.findById(id);
		
		if(indicadorSituacaoAprendizagem.isEmpty()) {
			throw new ObjectnotFoundException("INDICADOR SITUACAO APRENDIZAGEM COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		indicadorSituacaoAprendizagemRepository.deleteById(id);
	}
	
}
