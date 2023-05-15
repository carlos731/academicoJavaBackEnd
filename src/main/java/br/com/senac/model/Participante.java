package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.Enums.Status;

@Entity
@Table(name = "participante")
public class Participante implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participante_id")
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "participante_data_matricula")
	private LocalDate dataMatricula = LocalDate.now();
	@Column(name = "participante_status")
	private Status status;
	@ManyToOne
	@JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
	private Grupo grupoId;
	@OneToOne
	@JoinColumn(name = "estudante_id", referencedColumnName = "estudante_id")
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
