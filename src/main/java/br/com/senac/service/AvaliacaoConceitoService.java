package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.AvaliacaoConceito;
import br.com.senac.model.dtos.AvaliacaoConceitoDTO;
import br.com.senac.repository.AvaliacaoConceitoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class AvaliacaoConceitoService {
	
	@Autowired
	private AvaliacaoConceitoRepository avaliacaoConceitoRepository;
	
	public AvaliacaoConceitoDTO adicionar(AvaliacaoConceitoDTO avaliacaoConceitoDto) {
		avaliacaoConceitoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		AvaliacaoConceito avaliacaoConceito = mapper.map(avaliacaoConceitoDto, AvaliacaoConceito.class);
		avaliacaoConceito = avaliacaoConceitoRepository.save(avaliacaoConceito);
		avaliacaoConceitoDto.setId(avaliacaoConceito.getId());
		return avaliacaoConceitoDto;
	}
	
	public List<AvaliacaoConceitoDTO> obterTodos(){
		List<AvaliacaoConceito> avaliacaoConceitos = avaliacaoConceitoRepository.findAll();
		return avaliacaoConceitos.stream().map(avaliacaoConceito -> new ModelMapper().map(avaliacaoConceito, AvaliacaoConceitoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<AvaliacaoConceitoDTO> obterPorId(Integer id){
		Optional<AvaliacaoConceito> avaliacaoConceito = avaliacaoConceitoRepository.findById(id);
		
		if(avaliacaoConceito.isEmpty()) {
			throw new ObjectnotFoundException("AVALIAÇÃO CONCEITO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		AvaliacaoConceitoDTO dto = new ModelMapper().map(avaliacaoConceito.get(), AvaliacaoConceitoDTO.class);
		return Optional.of(dto);
	}
	
	public AvaliacaoConceitoDTO atualizar(Integer id, AvaliacaoConceitoDTO avaliacaoConceitoDto) {
		Optional<AvaliacaoConceito> avaliacaoConceitoId = avaliacaoConceitoRepository.findById(id);
		
		if(avaliacaoConceitoId.isEmpty()) {
			throw new ObjectnotFoundException("AVALIAÇÃO CONCEITO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		avaliacaoConceitoDto.setId(id);
		avaliacaoConceitoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		AvaliacaoConceito avaliacaoConceito = mapper.map(avaliacaoConceitoDto, AvaliacaoConceito.class);
		avaliacaoConceitoRepository.save(avaliacaoConceito);
		return avaliacaoConceitoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<AvaliacaoConceito> avaliacaoConceito = avaliacaoConceitoRepository.findById(id);
		
		if(avaliacaoConceito.isEmpty()) {
			throw new ObjectnotFoundException("AVALIAÇÃO CONCEITO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		avaliacaoConceitoRepository.deleteById(id);
	}
}
