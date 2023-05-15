package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.senac.model.Enums.BibliografiaStatus;

@Entity
@Table(name = "bibliografia")
public class Bibliografia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bibliografia_id")
	private Integer id;
	@Column(name = "bibliografia_nome")
	private String nome;
	@Column(name = "bibliografia_status")
	private BibliografiaStatus status;
	@ManyToOne
	@JoinColumn(name = "unidade_curricular_id", referencedColumnName = "unidade_curricular_id")
	private UnidadeCurricular  unidadeCurricularId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BibliografiaStatus getStatus() {
		return status;
	}
	public void setStatus(BibliografiaStatus status) {
		this.status = status;
	}
	public UnidadeCurricular getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(UnidadeCurricular unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}

}
