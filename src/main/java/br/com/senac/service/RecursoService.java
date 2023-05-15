package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Recurso;
import br.com.senac.model.dtos.RecursoDTO;
import br.com.senac.repository.RecursoRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;
	
	public RecursoDTO adicionar(RecursoDTO recursoDto) {
		recursoDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Recurso recurso = mapper.map(recursoDto, Recurso.class);
		recurso = recursoRepository.save(recurso);
		recursoDto.setId(recurso.getId());
		return recursoDto;
	}
	
	public RecursoDTO upload(RecursoDTO recursoDto) throws Exception {
		try {
            if(recursoDto.getFilename().contains("..")) {
                throw  new Exception("Filename contains invalid path sequence " + recursoDto.getFilename());
            }
            recursoDto.setId(null);
            ModelMapper mapper = new ModelMapper();
    		Recurso recurso = mapper.map(recursoDto, Recurso.class);
    		recurso = recursoRepository.save(recurso);
    		recursoDto.setId(recurso.getId());
    		return recursoDto;

       } catch (Exception e) {
            throw new Exception("Could not save File: " + recursoDto.getFilename());
       }
	
	}
	
	public List<RecursoDTO> obterTodos(){
		List<Recurso> recursos = recursoRepository.findAll();
		return recursos.stream().map(recurso -> new ModelMapper().map(recurso, RecursoDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<RecursoDTO> obterPorId(Integer id){
		Optional<Recurso> recurso = recursoRepository.findById(id);
		
		if(recurso.isEmpty()) {
			throw new ObjectnotFoundException("RECURSO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		RecursoDTO dto = new ModelMapper().map(recurso.get(), RecursoDTO.class);
		return Optional.of(dto);
	}
	
	public List<RecursoDTO> obterPorUsuario(Integer usuarioId){
		List<Recurso> recursos = recursoRepository.findByUsuario(usuarioId);
		
		if(recursos.isEmpty()) {
			throw new ObjectnotFoundException("NENHUM RECURSO ENCONTRADO PARA USUARIO COM ID:" + usuarioId);
		}
		
		return recursos.stream().map(recurso -> new ModelMapper().map(recurso, RecursoDTO.class)).collect((Collectors.toList()));
	}
	
	public RecursoDTO atualizar(Integer id, RecursoDTO cursoDto) {
		Optional<Recurso> cursoId = recursoRepository.findById(id);
		
		if(cursoId.isEmpty()) {
			throw new ObjectnotFoundException("RECURSO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		cursoDto.setId(id);
		cursoDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Recurso recurso = mapper.map(cursoDto, Recurso.class);
		recursoRepository.save(recurso);
		return cursoDto;
	}
	
	
	public void deletar(Integer id) {
		Optional<Recurso> recurso = recursoRepository.findById(id);
		
		if(recurso.isEmpty()) {
			throw new ObjectnotFoundException("RECURSO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		recursoRepository.deleteById(id);
	}
}
