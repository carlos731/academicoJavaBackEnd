package br.com.senac.controller.response;

import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.Status;

public class ColaboradorResponse {
	
	private Integer id;
	private Status status;
	private Usuario usuarioId;
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
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getPermissao() {
		return permissao;
	}
	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
	}
	
}
