package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.ProfessorStatus;

public class ProfessorRequest {
	
	private Integer id;
	//@NotNull(message = "O CAMPO PROFESSOR_STATUS DEVE SER PREENCHIDO!!")
	private ProfessorStatus status;
	@NotNull(message = "O CAMPO USUARIO_ID DEVE SER PREENCHIDO!!")
	private Integer usuarioId;

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
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
