package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Bibliografia;
import br.com.senac.model.dtos.BibliografiaDTO;
import br.com.senac.repository.BibliografiaRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class BibliografiaService {
	
	@Autowired
	private BibliografiaRepository bibliografiaRepository;
	
	public BibliografiaDTO adicionar(BibliografiaDTO bibliografiaDto) {
		bibliografiaDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Bibliografia bibliografia = mapper.map(bibliografiaDto, Bibliografia.class);	
		bibliografia = bibliografiaRepository.save(bibliografia);
		bibliografiaDto.setId(bibliografia.getId());
		return bibliografiaDto;
	}
	
	public List<BibliografiaDTO> obterTodos(){
		List<Bibliografia> bibliografias = bibliografiaRepository.findAll();
		return bibliografias.stream().map(bibliografia -> new ModelMapper().map(bibliografia, BibliografiaDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<BibliografiaDTO> obterPorId(Integer id){
		Optional<Bibliografia> bibliografia = bibliografiaRepository.findById(id);
		
		if(bibliografia.isEmpty()) {
			throw new ObjectnotFoundException("Bibliografia COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		BibliografiaDTO dto = new ModelMapper().map(bibliografia.get(), BibliografiaDTO.class);
		return Optional.of(dto);
	}
	
	public void deletar(Integer id) {
		Optional<Bibliografia> bibliografia = bibliografiaRepository.findById(id);
		
		if(bibliografia.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		bibliografiaRepository.deleteById(id);
	}
	
	public BibliografiaDTO atualizar(Integer id, BibliografiaDTO bibliografiaDto) {
		Optional<Bibliografia> bibliografiaId = bibliografiaRepository.findById(id);
		
		if(bibliografiaId.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		bibliografiaDto.setId(id);
		bibliografiaDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Bibliografia bibliografia = mapper.map(bibliografiaDto, Bibliografia.class);
		bibliografiaRepository.save(bibliografia);
		return bibliografiaDto;
	}
}
