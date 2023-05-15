package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.Status;

public class RecursoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO NOME ARQUIVO DEVE SER PREENCHIDO!!")
	private String filename;
	private byte[] file;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Status status;
	@NotNull(message = "O CAMPO USUARIO DEVE SER PREENCHIDO!!")
	private Integer usuarioId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
