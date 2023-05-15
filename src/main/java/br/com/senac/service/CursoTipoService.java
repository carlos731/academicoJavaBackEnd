package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.CursoTipo;
import br.com.senac.model.dtos.CursoTipoDTO;
import br.com.senac.repository.CursoTipoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class CursoTipoService {

	@Autowired
	private CursoTipoRepository cursoTipoRepository;
	
	public CursoTipoDTO adicionar(CursoTipoDTO cursoTipoDto) {
		cursoTipoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		CursoTipo cursoTipo = mapper.map(cursoTipoDto, CursoTipo.class);
		cursoTipo = cursoTipoRepository.save(cursoTipo);
		cursoTipoDto.setId(cursoTipo.getId());
		return cursoTipoDto;
	}
	
	public List<CursoTipoDTO> obterTodos(){
		List<CursoTipo> cursoTipos = cursoTipoRepository.findAll();
		return cursoTipos.stream().map(tipo -> new ModelMapper().map(tipo, CursoTipoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<CursoTipoDTO> obterPorId(Integer id){
		Optional<CursoTipo> cursoTipo = cursoTipoRepository.findById(id);
		
		if(cursoTipo.isEmpty()) {
			throw new ObjectnotFoundException("TIPO DO CURSO COM ID: '" + id + "' NÂO ENCONTRADO!");
		}
		
		CursoTipoDTO dto = new ModelMapper().map(cursoTipo.get(), CursoTipoDTO.class);
		return Optional.of(dto);
	}
	
	public CursoTipoDTO atualizar(Integer id, CursoTipoDTO cursoTipoDto) {
		Optional<CursoTipo> cursoTipoId = cursoTipoRepository.findById(id);
		
		if(cursoTipoId.isEmpty()) {
			throw new ObjectnotFoundException("TIPO DO CURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		cursoTipoDto.setId(id);
		cursoTipoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		CursoTipo cursoTipo = mapper.map(cursoTipoDto, CursoTipo.class);
		cursoTipoRepository.save(cursoTipo);
		return cursoTipoDto;
	}
	
	public void deletar(Integer id) {
		Optional<CursoTipo> cursoTipo = cursoTipoRepository.findById(id);
		
		if(cursoTipo.isEmpty()) {
			throw new ObjectnotFoundException("TIPO DO CURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		cursoTipoRepository.deleteById(id);
	}
}
