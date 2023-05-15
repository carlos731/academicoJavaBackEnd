package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.Status;

public class SenacCoinRequest {
	private Integer id;
	@NotNull(message = "O CAMPO SALDO DEVE SER PREENCHIDO!!")
	private Long saldo;
	//@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Status status;
	@NotNull(message = "O CAMPO USUARIOID DEVE SER PREENCHIDO!!")
	private Integer usuarioId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getSaldo() {
		return saldo;
	}
	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
}
