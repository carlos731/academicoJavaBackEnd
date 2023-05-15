package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Copetencia;
import br.com.senac.model.dtos.CopetenciaDTO;
import br.com.senac.repository.CopetenciaRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class CopetenciaService {
	
	@Autowired
	private CopetenciaRepository copetenciaRepository;
	

	public CopetenciaDTO adicionar(CopetenciaDTO copetenciaDto) {
		copetenciaDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Copetencia copetencia = mapper.map(copetenciaDto, Copetencia.class);
		copetencia = copetenciaRepository.save(copetencia);
		copetenciaDto.setId(copetencia.getId());
		return copetenciaDto;
	}
	
	public List<CopetenciaDTO> obterTodos(){
		List<Copetencia> copetencias = copetenciaRepository.findAll();
		return copetencias.stream().map(copetencia -> new ModelMapper().map(copetencia, CopetenciaDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<CopetenciaDTO> obterPorId(Integer id){
		Optional<Copetencia> copetencia = copetenciaRepository.findById(id);
		
		if(copetencia.isEmpty()) {
			throw new ObjectnotFoundException("COPETENCIA COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		CopetenciaDTO dto = new ModelMapper().map(copetencia.get(), CopetenciaDTO.class);
		return Optional.of(dto);
	}
	
	public List<CopetenciaDTO> obterPorUnidadeCurricularId(Integer id){
		List<Copetencia> copetencias = copetenciaRepository.findByUnidadeCurricularId(id);
		
		if(copetencias.isEmpty()) {
			throw new ObjectnotFoundException("COPETÊNCIA COM UNIDADE-CURRICULAR INFORMADO : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return copetencias.stream().map(copetencia -> new ModelMapper().map(copetencia, CopetenciaDTO.class)).collect((Collectors.toList()));
	}
	
	
	public CopetenciaDTO atualizar(Integer id, CopetenciaDTO copetenciaDto) {
		Optional<Copetencia> copetenciaId = copetenciaRepository.findById(id);
		
		if(copetenciaId.isEmpty()) {
			throw new ObjectnotFoundException("COPETENCIA COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		copetenciaDto.setId(id);
		copetenciaDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Copetencia copetencia = mapper.map(copetenciaDto, Copetencia.class);
		copetenciaRepository.save(copetencia);
		return copetenciaDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Copetencia> copetencia = copetenciaRepository.findById(id);
		
		if(copetencia.isEmpty()) {
			throw new ObjectnotFoundException("COPETENCIA COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		copetenciaRepository.deleteById(id);
	}
}
