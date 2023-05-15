package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.senac.model.Enums.GrauDificuldadeStatus;

@Entity
@Table(name = "grau_dificuldade")
public class GrauDificuldade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grau_dificuldade_id")
	private Integer id;
	@Column(name = "grau_dificuldade_descricao")
	private String descricao;
	@Column(name = "grau_dificuldade_status")
	private GrauDificuldadeStatus status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public GrauDificuldadeStatus getStatus() {
		return status;
	}
	public void setStatus(GrauDificuldadeStatus status) {
		this.status = status;
	}
	
}
