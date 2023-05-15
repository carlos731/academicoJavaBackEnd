package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.Status;

public class ColaboradorRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Status status;
	@NotNull(message = "O CAMPO USUARIO_ID DEVE SER PREENCHIDO!!")
	private Integer usuarioId;
	@NotNull(message = "O CAMPO PERMISSÃO DEVE SER PREENCHIDO!!")
	private Integer permissao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getPermissao() {
		return permissao;
	}
	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
	}
	
}
