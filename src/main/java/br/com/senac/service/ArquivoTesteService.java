package br.com.senac.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.senac.model.ArquivoTeste;
import br.com.senac.repository.ArquivoTesteRepository;
import br.com.senac.service.exceptions.ObjectnotFoundException;

@Service
public class ArquivoTesteService {
	
	@Autowired
	private ArquivoTesteRepository arquivoRepository;
	
	public ArquivoTeste saveArquivo(MultipartFile file) throws Exception {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       
       try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence " + fileName);
            }

            ArquivoTeste arquivo = new ArquivoTeste(fileName, file.getContentType(), file.getSize(), file.getBytes(), new Date(), "http://localhost:8080/arquivo/download/1");
            return arquivoRepository.save(arquivo);

       } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
       }
    }

    public ArquivoTeste getArquivo(Integer fileId) throws Exception {
        return arquivoRepository.findById(fileId).orElseThrow( () -> new Exception("File not found with Id: " + fileId));
    }
    
	public List<ArquivoTeste> findAll(){
		return arquivoRepository.buscarTodosArquivos();
	}

	public ArquivoTeste findById(Integer id) {
		Optional<ArquivoTeste> obj = arquivoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}
    

}
