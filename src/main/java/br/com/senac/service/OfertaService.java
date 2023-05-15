package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Oferta;
import br.com.senac.model.dtos.OfertaDTO;
import br.com.senac.repository.OfertaRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class OfertaService {

	@Autowired 
	private OfertaRepository ofertaRepository;
	
	public OfertaDTO adicionar(OfertaDTO ofertaDto) {
		ofertaDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Oferta oferta = mapper.map(ofertaDto, Oferta.class);
		oferta = ofertaRepository.save(oferta);
		ofertaDto.setId(oferta.getId());
		return ofertaDto;
	}
	
	public List<OfertaDTO> obterTodos(){
		List<Oferta> ofertas = ofertaRepository.findAll();
		return ofertas.stream().map(oferta -> new ModelMapper().map(oferta, OfertaDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<OfertaDTO> obterPorId(Integer id){
		Optional<Oferta> oferta = ofertaRepository.findById(id);
		
		if(oferta.isEmpty()) {
			throw new ObjectnotFoundException("OFERTA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		OfertaDTO dto = new ModelMapper().map(oferta.get(), OfertaDTO.class);
		return Optional.of(dto);
	}
	
	public OfertaDTO atualizar(Integer id, OfertaDTO ofertaDto) {
		Optional<Oferta> ofertaId = ofertaRepository.findById(id);
		
		if(ofertaId.isEmpty()) {
			throw new ObjectnotFoundException("OFERTA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		ofertaDto.setId(id);
		ofertaDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Oferta oferta = mapper.map(ofertaDto, Oferta.class);
		ofertaRepository.save(oferta);
		return ofertaDto;
	}
	
	public void deletar(Integer id) {
		Optional<Oferta> oferta = ofertaRepository.findById(id);
		
		if(oferta.isEmpty()) {
			throw new ObjectnotFoundException("OFERTA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		ofertaRepository.deleteById(id);
	}
}
