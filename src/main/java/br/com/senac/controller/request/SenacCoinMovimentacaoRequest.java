package br.com.senac.controller.request;

import br.com.senac.model.Enums.Status;

public class SenacCoinMovimentacaoRequest {

	private Integer id;
	private String observacao;
	private Long valor;
	private Status status;
	private Integer senacCoinId;
	private Integer usuarioId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getSenacCoinId() {
		return senacCoinId;
	}
	public void setSenacCoinId(Integer senacCoinId) {
		this.senacCoinId = senacCoinId;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

}
