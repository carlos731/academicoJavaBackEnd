package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.RegistroAvaliacao;
import br.com.senac.model.dtos.RegistroAvaliacaoDTO;
import br.com.senac.repository.RegistroAvaliacaoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class RegistroAvaliacaoService {

	@Autowired
	private RegistroAvaliacaoRepository registroAvaliacaoRepository;
	
	public RegistroAvaliacaoDTO adicionar(RegistroAvaliacaoDTO registroAvaliacaoDto) {
		registroAvaliacaoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		RegistroAvaliacao registroAvaliacao = mapper.map(registroAvaliacaoDto, RegistroAvaliacao.class);
		registroAvaliacao = registroAvaliacaoRepository.save(registroAvaliacao);
		registroAvaliacaoDto.setId(registroAvaliacao.getId());
		return registroAvaliacaoDto;
	}
	
	public List<RegistroAvaliacaoDTO> obterTodos(){
		List<RegistroAvaliacao> registroAvaliacoes = registroAvaliacaoRepository.findAll();
		return registroAvaliacoes.stream().map(registroAvaliacao -> new ModelMapper().map(registroAvaliacao, RegistroAvaliacaoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<RegistroAvaliacaoDTO> obterPorId(Integer id){
		Optional<RegistroAvaliacao> registroAvaliacao = registroAvaliacaoRepository.findById(id);
		
		if(registroAvaliacao.isEmpty()) {
			throw new ObjectnotFoundException("REGISTRO AVALIAÇÃO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		RegistroAvaliacaoDTO dto = new ModelMapper().map(registroAvaliacao.get(), RegistroAvaliacaoDTO.class);
		return Optional.of(dto);
	}
	
	public RegistroAvaliacaoDTO atualizar(Integer id, RegistroAvaliacaoDTO registroAvaliacaoDto) {
		Optional<RegistroAvaliacao> registroAvaliacaoId = registroAvaliacaoRepository.findById(id);
		
		if(registroAvaliacaoId.isEmpty()) {
			throw new ObjectnotFoundException("REGISTRO AVALIAÇÃO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		registroAvaliacaoDto.setId(id);
		registroAvaliacaoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		RegistroAvaliacao registroAvaliacao = mapper.map(registroAvaliacaoDto, RegistroAvaliacao.class);
		registroAvaliacaoRepository.save(registroAvaliacao);
		return registroAvaliacaoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<RegistroAvaliacao> registroAvaliacao = registroAvaliacaoRepository.findById(id);
		
		if(registroAvaliacao.isEmpty()) {
			throw new ObjectnotFoundException("REGISTRO AVALIAÇÃO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		registroAvaliacaoRepository.deleteById(id);
	}
	
}
