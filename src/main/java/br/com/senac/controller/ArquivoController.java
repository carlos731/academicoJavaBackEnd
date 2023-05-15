package br.com.senac.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.controller.request.ArquivoRequest;
import br.com.senac.controller.response.ArquivoResponse;
import br.com.senac.model.Arquivo;
import br.com.senac.model.Atividade;
import br.com.senac.model.Enums.ArquivoStatus;
import br.com.senac.model.dtos.ArquivoDTO;
import br.com.senac.service.ArquivoService;

@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {
	
	@Autowired
	private ArquivoService arquivoService;
	
	@PostMapping
	public ResponseEntity<ArquivoResponse> adicionar(@Valid @RequestBody ArquivoRequest objetoAprendizagemReq){
		ModelMapper mapper = new ModelMapper();
		ArquivoDTO arquivoDto = mapper.map(objetoAprendizagemReq, ArquivoDTO.class);
		arquivoDto = arquivoService.adicionar(arquivoDto);
		return new ResponseEntity<>(mapper.map(arquivoDto, ArquivoResponse.class), HttpStatus.CREATED);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<List<ArquivoResponse>> upload(
			@RequestParam("descricao") String descricao, 
			@RequestParam("file") MultipartFile[] files,
			@RequestParam("atividades") List<Atividade> atividades
			) throws Exception{
		//ModelMapper mapper = new ModelMapper();
		
		Arquivo arquivo = new Arquivo();
		List<Arquivo> arquivos = new ArrayList<>();
		
    	for(MultipartFile file : files) {
    		
    		arquivo.setDescricao(descricao);
    		arquivo.setNomeArquivo(file.getOriginalFilename());
    		arquivo.setBlob(file.getBytes());
    		arquivo.setExtensao(file.getContentType());
    		arquivo.setFileSize(file.getSize());
    		arquivo.setStatus(ArquivoStatus.ATIVO);
    		arquivo.setAtividades(atividades);
    		arquivos.add(arquivo);
    		
    		arquivo = arquivoService.upload(file, descricao, atividades);
    	}
    	
    	//List<ArquivoResponse> resposta = arquivos.stream().map(arq -> mapper.map(arq, ArquivoResponse.class)).collect(Collectors.toList());
		
		//return new ResponseEntity<>(mapper.map(arquivo, ArquivoResponse.class), HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) throws Exception {
        Arquivo arquivo = null;
        arquivo = arquivoService.getArquivo(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(arquivo.getExtensao()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "arquivo; filename=\"" + arquivo.getNomeArquivo()
                + "\"")
                .body(new ByteArrayResource(arquivo.getBlob()));
    }
	
	@GetMapping
	public ResponseEntity<List<ArquivoResponse>> obterTodos(){
		List<ArquivoDTO> arquivos = arquivoService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<ArquivoResponse> resposta = arquivos.stream().map(arquivo -> mapper.map(arquivo, ArquivoResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ArquivoResponse>> obterPorId(@PathVariable Integer id){
		Optional<ArquivoDTO> arquivoEncontrado = arquivoService.obterPorId(id);
		ArquivoResponse arquivo = new ModelMapper().map(arquivoEncontrado.get(), ArquivoResponse.class);
		return new ResponseEntity<>(Optional.of(arquivo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ArquivoResponse> atualizar(@Valid @RequestBody ArquivoRequest objetoAprendizagemReq, @PathVariable Integer id){
		ModelMapper mapper = new ModelMapper();
		ArquivoDTO arquivoDto = mapper.map(objetoAprendizagemReq, ArquivoDTO.class);
		arquivoDto = arquivoService.atualizar(id, arquivoDto);
		return new ResponseEntity<>(mapper.map(arquivoDto, ArquivoResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		arquivoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
