package br.com.senac.controller.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.SenacCoin;
import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.Status;

public class SenacCoinMovimentacaoResponse {
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private String observacao;
	private Long valor;
	private Status status;
	private SenacCoin senacCoinId;
	private Usuario usuarioId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public SenacCoin getSenacCoinId() {
		return senacCoinId;
	}
	public void setSenacCoinId(SenacCoin senacCoinId) {
		this.senacCoinId = senacCoinId;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

}
