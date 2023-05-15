package br.com.senac.model.dtos;

import br.com.senac.model.Enums.AvaliacaoTipoStatus;

public class AvaliacaoTipoDTO {
	
	private Integer id;
	private String descricao;
	private AvaliacaoTipoStatus status;
	
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
	public AvaliacaoTipoStatus getStatus() {
		return status;
	}
	public void setStatus(AvaliacaoTipoStatus status) {
		this.status = status;
	}
}
