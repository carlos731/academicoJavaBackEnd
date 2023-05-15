package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.BibliografiaStatus;

public class BibliografiaRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO NOME DEVE SER PREENCHIDO!!!")
	private String nome;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!!")
	private BibliografiaStatus status;
	@NotNull(message = "O CAMPO UNIDADE CURRICULAR DEVE SER PREENCHIDO!!!")
	private Integer  unidadeCurricularId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BibliografiaStatus getStatus() {
		return status;
	}
	public void setStatus(BibliografiaStatus status) {
		this.status = status;
	}
	public Integer getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(Integer unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	
}
