package br.com.senac.model.dtos;

import java.util.Date;

import br.com.senac.model.SenacCoin;
import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.Status;

public class SenacCoinMovimentacaoDTO {
	
	private Integer id;
	private Date data = new Date();
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
