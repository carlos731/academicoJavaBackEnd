package br.com.senac.controller.response;

import br.com.senac.model.Copetencia;

public class CopetenciaIndicadorResponse {
	
	private Integer id;
	private String descricao;
	private Integer status;
	private Copetencia copetenciaId;
	
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
	public Copetencia getCopetenciaId() {
		return copetenciaId;
	}
	public void setCopetenciaId(Copetencia copetenciaId) {
		this.copetenciaId = copetenciaId;
	}
}
