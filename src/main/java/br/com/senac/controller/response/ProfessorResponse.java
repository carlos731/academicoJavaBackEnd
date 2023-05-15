package br.com.senac.controller.response;

import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.ProfessorStatus;

public class ProfessorResponse {
	
	private Integer id;
	private ProfessorStatus status;
	private Usuario usuarioId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProfessorStatus getStatus() {
		return status;
	}
	public void setStatus(ProfessorStatus status) {
		this.status = status;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	

}
