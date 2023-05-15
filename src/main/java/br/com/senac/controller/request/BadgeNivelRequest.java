package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

public class BadgeNivelRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO BADGE_NIVEL_DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	
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

	
}
