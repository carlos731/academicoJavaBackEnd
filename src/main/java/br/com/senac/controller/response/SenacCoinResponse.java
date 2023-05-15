package br.com.senac.controller.response;

import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.Status;

public class SenacCoinResponse {
	private Integer id;
	private Long saldo;
	private Status status;
	private Usuario usuarioId;
	
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
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
}
