package br.com.senac.model.dtos;

import br.com.senac.model.Enums.AtividadeTipoStatus;

public class AtividadeTipoDTO {
	
	private Integer id;
	private String descricao;
	private AtividadeTipoStatus status;
	
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
	public AtividadeTipoStatus getStatus() {
		return status;
	}
	public void setStatus(AtividadeTipoStatus status) {
		this.status = status;
	}
	
}


