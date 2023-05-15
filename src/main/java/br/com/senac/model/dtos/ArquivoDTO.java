package br.com.senac.model.dtos;

import java.util.Date;
import java.util.List;

import br.com.senac.model.Atividade;
import br.com.senac.model.Enums.ArquivoStatus;

public class ArquivoDTO {
	
	private Integer id;
	private String Descricao;
	private String nomeArquivo;
	private String extensao;
	private Long fileSize;
	private Date dataCadastro = new Date();
	private byte[] blob;
	private ArquivoStatus status;
	private List<Atividade> atividades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public ArquivoStatus getStatus() {
		return status;
	}

	public void setStatus(ArquivoStatus status) {
		this.status = status;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	
}
