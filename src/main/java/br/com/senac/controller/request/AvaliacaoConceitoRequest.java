package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.AvaliacaoConceitoStatus;

public class AvaliacaoConceitoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO")
	private String descricao;
	@NotNull(message = "O CAMPO VALOR MIN DEVE SER PREENCHIDO")
	private Integer valorMin;
	@NotNull(message = "O CAMPO VALOR MAX DEVE SER PREENCHIDO")
	private Integer valorMax;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO")
	private AvaliacaoConceitoStatus status;
	
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
	public Integer getValorMin() {
		return valorMin;
	}
	public void setValorMin(Integer valorMin) {
		this.valorMin = valorMin;
	}
	public Integer getValorMax() {
		return valorMax;
	}
	public void setValorMaxx(Integer valorMax) {
		this.valorMax = valorMax;
	}
	public AvaliacaoConceitoStatus getStatus() {
		return status;
	}
	public void setStatus(AvaliacaoConceitoStatus status) {
		this.status = status;
	}
	
}
