package br.com.senac.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senac.controller.response.ArquivoTesteResponse;
import br.com.senac.model.ArquivoTeste;
import br.com.senac.service.ArquivoTesteService;

@RestController
@RequestMapping("/arquivo")
public class ArquivoTesteController {
	
	@Autowired
	private ArquivoTesteService arquivoService;

    @PostMapping("/upload")
    public ArquivoTesteResponse uploadFile(
    		@RequestParam("file")MultipartFile file,
    		@RequestParam("info")String descricao) throws Exception {
        
    	ArquivoTeste arquivo = null;
        String downloadURl = "";
        arquivo = arquivoService.saveArquivo(file);
        
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/arquivo/download/").path(arquivo.getId().toString()).toUriString();

        arquivo = new ArquivoTeste(descricao, file.getContentType(), file.getSize(), file.getBytes(), new Date(), downloadURl);
        
        return new ArquivoTesteResponse(descricao, downloadURl, file.getContentType(), file.getSize(), new Date());
    }

    @PostMapping("/uploadMultipleFiles")
    public ResponseEntity<ArquivoTesteResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws Exception{
    	ArquivoTeste arquivo = null;
    	String downloadURL = "";
    	
    	for(MultipartFile file : files) {
    		//System.out.println("File name: " + file.getOriginalFilename());
    		arquivo = arquivoService.saveArquivo(file);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) throws Exception {
        ArquivoTeste arquivo = null;
        arquivo = arquivoService.getArquivo(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(arquivo.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "arquivo; filename=\"" + arquivo.getFileName()
                + "\"")
                .body(new ByteArrayResource(arquivo.getData()));
    }
    
	@GetMapping
	public ResponseEntity<List<ArquivoTeste>> obterArquivo(){
		List<ArquivoTeste> arquivo = arquivoService.findAll();
		return new ResponseEntity<>(arquivo, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArquivoTeste> findById(@PathVariable Integer id){
		ArquivoTeste arquivo = arquivoService.findById(id);
		return new ResponseEntity<>(arquivo, HttpStatus.OK);
	}
    
}
