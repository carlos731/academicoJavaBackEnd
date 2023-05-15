package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.SenacCoinMovimentacao;
import br.com.senac.model.Enums.Status;
import br.com.senac.model.dtos.SenacCoinMovimentacaoDTO;
import br.com.senac.repository.SenacCoinMovimentacaoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class SenacCoinMovimentacaoService {
	
	@Autowired
	private SenacCoinMovimentacaoRepository senacCoinMovimentacaoRepository;
	
	public SenacCoinMovimentacaoDTO adicionar(SenacCoinMovimentacaoDTO senacCoinMovimentacaoDto) {
		senacCoinMovimentacaoDto.setId(null);
		senacCoinMovimentacaoDto.setStatus(Status.ATIVO);
		ModelMapper mapper = new ModelMapper();
		SenacCoinMovimentacao senacCoinMovimentacao = mapper.map(senacCoinMovimentacaoDto, SenacCoinMovimentacao.class);
		senacCoinMovimentacao = senacCoinMovimentacaoRepository.save(senacCoinMovimentacao);
		senacCoinMovimentacaoDto.setId(senacCoinMovimentacao.getId());
		return senacCoinMovimentacaoDto;
	}
	
	public List<SenacCoinMovimentacaoDTO> obterTodos(){
		List<SenacCoinMovimentacao> senacCoinMovimentacaos = senacCoinMovimentacaoRepository.findAll();
		return senacCoinMovimentacaos.stream().map(senacCoinMovimentacao -> new ModelMapper().map(senacCoinMovimentacao, SenacCoinMovimentacaoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<SenacCoinMovimentacaoDTO> obterPorId(Integer id){
		Optional<SenacCoinMovimentacao> senacCoinMovimentacao = senacCoinMovimentacaoRepository.findById(id);
		
		if(senacCoinMovimentacao.isEmpty()) {
			throw new ObjectnotFoundException("SENAC_COIN COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		SenacCoinMovimentacaoDTO dto = new ModelMapper().map(senacCoinMovimentacao.get(), SenacCoinMovimentacaoDTO.class);
		return Optional.of(dto);
	}
	
	public SenacCoinMovimentacaoDTO atualizar(Integer id, SenacCoinMovimentacaoDTO senacCoinMovimentacaoDto) {
		Optional<SenacCoinMovimentacao> senacCoinMovimentacaoId = senacCoinMovimentacaoRepository.findById(id);
		
		if(senacCoinMovimentacaoId.isEmpty()) {
			throw new ObjectnotFoundException("SENAC_COIN COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		senacCoinMovimentacaoDto.setId(id);
		senacCoinMovimentacaoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		SenacCoinMovimentacao SenacCoinMovimentacao = mapper.map(senacCoinMovimentacaoDto, SenacCoinMovimentacao.class);
		senacCoinMovimentacaoRepository.save(SenacCoinMovimentacao);
		return senacCoinMovimentacaoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<SenacCoinMovimentacao> SenacCoinMovimentacao = senacCoinMovimentacaoRepository.findById(id);
		
		if(SenacCoinMovimentacao.isEmpty()) {
			throw new ObjectnotFoundException("SENAC_COIN COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		senacCoinMovimentacaoRepository.deleteById(id);
	}
}
