package br.com.senac.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "copetencia_indicador")
public class CopetenciaIndicador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "copetencia_indicador_id")
	private Integer id;
	@Column(name = "copetencia_indicador_descricao")
	private String descricao;
	@Column(name = "copetencia_indicador_status")
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "copetencia_id", referencedColumnName = "copetencia_id")
	private Copetencia copetenciaId;
	@JsonIgnore
	@ManyToMany(mappedBy = "indicadores")
	private List<SituacaoAprendizagem> situacoesAprendizagens;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Copetencia getCopetenciaId() {
		return copetenciaId;
	}
	public void setCopetenciaId(Copetencia copetenciaId) {
		this.copetenciaId = copetenciaId;
	}
	public List<SituacaoAprendizagem> getSituacoesAprendizagens() {
		return situacoesAprendizagens;
	}
	public void setSituacoesAprendizagens(List<SituacaoAprendizagem> situacoesAprendizagens) {
		this.situacoesAprendizagens = situacoesAprendizagens;
	}
	

}
