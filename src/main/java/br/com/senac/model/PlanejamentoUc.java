package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "planejamento_uc")
public class PlanejamentoUc implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planejamento_uc_id")
	private Integer id;
	@Column(name = "planejamento_uc_descricao")
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "planejamento_uc_data_aprovacao")
	private LocalDate dataAprovacao = LocalDate.now();
	@Column(name = "planejamento_uc_status")
	private Integer status; 
	@OneToOne
	@JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
	private Grupo grupoId;
	
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
	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}
	public void setDataAprovacao(LocalDate dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
		this.grupoId = grupoId;
	}
	
}
