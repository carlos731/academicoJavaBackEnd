package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.AvaliacaoTipoStatus;

public class AvaliacaoTipoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
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
