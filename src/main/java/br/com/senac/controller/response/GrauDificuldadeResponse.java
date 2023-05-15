package br.com.senac.controller.response;

import br.com.senac.model.Enums.GrauDificuldadeStatus;

public class GrauDificuldadeResponse {
	
	private Integer id;
	private String descricao;
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
