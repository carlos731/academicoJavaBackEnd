package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.senac.model.Enums.ProfessorStatus;


@Entity
@Table(name = "professor")
public class Professor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professor_id")
	private Integer id;
	
	@Column(name = "professor_status")
	private ProfessorStatus status;
	
	//@OneToOne//(mappedBy = "usuario_id")
	//@JoinColumn(name = "usuario_id", unique = true)
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
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
