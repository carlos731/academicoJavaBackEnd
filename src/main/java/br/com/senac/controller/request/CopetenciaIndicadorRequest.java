package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

public class CopetenciaIndicadorRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPOS DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPOS STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	@NotNull(message = "O CAMPOS COPETENCIA DEVE SER PREENCHIDO!!")
	private Integer copetenciaId;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCopetenciaId() {
		return copetenciaId;
	}
	public void setCopetenciaId(Integer copetenciaId) {
		this.copetenciaId = copetenciaId;
	}
	
}
