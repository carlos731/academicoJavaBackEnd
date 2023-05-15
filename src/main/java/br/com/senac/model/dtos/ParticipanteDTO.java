package br.com.senac.model.dtos;

import java.time.LocalDate;

import br.com.senac.model.Estudante;
import br.com.senac.model.Grupo;
import br.com.senac.model.Enums.Status;

public class ParticipanteDTO {

	private Integer id;
	private LocalDate dataMatricula = LocalDate.now();
	private Status status;
	private Grupo grupoId;
	private Estudante estudanteId;
	
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
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
		this.grupoId = grupoId;
	}
	public Estudante getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Estudante estudanteId) {
		this.estudanteId = estudanteId;
	}
}	
