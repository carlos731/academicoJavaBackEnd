package br.com.senac.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.Status;

public class ParticipanteRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO MATRICULA DEVE SER PREENCHIDO!!")
	private LocalDate dataMatricula = LocalDate.now();
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO")
	private Status status;
	@NotNull(message = "O CAMPO GRUPO DEVE SER PREENCHIDO!!")
	private Integer grupoId;
	@NotNull(message = "O CAMPO ESTUDANTE DEVE SER PREENCHIDO!!")
	private Integer estudanteId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
	public Integer getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Integer estudanteId) {
		this.estudanteId = estudanteId;
	}
	
}
