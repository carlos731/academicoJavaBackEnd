package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.GrauDificuldadeStatus;

public class GrauDificuldadeRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO")
	private String descricao;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO")
	private GrauDificuldadeStatus status;
	
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
	public GrauDificuldadeStatus getStatus() {
		return status;
	}
	public void setStatus(GrauDificuldadeStatus status) {
		this.status = status;
	}
	
}
