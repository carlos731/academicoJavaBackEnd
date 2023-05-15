package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.senac.model.Enums.AtividadeTipoStatus;

@Entity
@Table(name = "atividade_tipo")
public class AtividadeTipo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atividade_tipo_id")
	private Integer id;
	@Column(name = "atividade_tipo_descricao")
	private String descricao;
	@Column(name = "atividade_tipo_status")
	private AtividadeTipoStatus status;
	
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
	public AtividadeTipoStatus getStatus() {
		return status;
	}
	public void setStatus(AtividadeTipoStatus status) {
		this.status = status;
	}
	
}
