package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.SenacCoin;
import br.com.senac.model.Enums.Status;
import br.com.senac.model.dtos.SenacCoinDTO;
import br.com.senac.repository.SenacCoinRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class SenacCoinService {
	
	@Autowired
	private SenacCoinRepository senacCoinRepository;
	
	public SenacCoinDTO adicionar(SenacCoinDTO senacCoinDto) {
		senacCoinDto.setId(null);
		senacCoinDto.setStatus(Status.ATIVO);
		ModelMapper mapper = new ModelMapper();
		SenacCoin senacCoin = mapper.map(senacCoinDto, SenacCoin.class);
		senacCoin = senacCoinRepository.save(senacCoin);
		senacCoinDto.setId(senacCoin.getId());
		return senacCoinDto;
	}
	
	public List<SenacCoinDTO> obterTodos(){
		List<SenacCoin> senacCoins = senacCoinRepository.findAll();
		return senacCoins.stream().map(senacCoin -> new ModelMapper().map(senacCoin, SenacCoinDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<SenacCoinDTO> obterPorId(Integer id){
		Optional<SenacCoin> senacCoin = senacCoinRepository.findById(id);
		
		if(senacCoin.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		SenacCoinDTO dto = new ModelMapper().map(senacCoin.get(), SenacCoinDTO.class);
		return Optional.of(dto);
	}
	
	public SenacCoinDTO atualizar(Integer id, SenacCoinDTO senacCoinDto) {
		Optional<SenacCoin> senacCoinId = senacCoinRepository.findById(id);
		
		if(senacCoinId.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		senacCoinDto.setId(id);
		senacCoinDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		SenacCoin senacCoin = mapper.map(senacCoinDto, SenacCoin.class);
		senacCoinRepository.save(senacCoin);
		return senacCoinDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<SenacCoin> senacCoin = senacCoinRepository.findById(id);
		
		if(senacCoin.isEmpty()) {
			throw new ObjectnotFoundException("CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		senacCoinRepository.deleteById(id);
	}
	
}
