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

@Entity
@Table(name = "indicador_situacao_aprendizagem")
public class IndicadorSituacaoAprendizagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "indicador_situacao_aprendizagem_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "copetencia_indicador_id", referencedColumnName = "copetencia_indicador_id")
	private CopetenciaIndicador copetenciaIndicadorId;
	@ManyToOne
	@JoinColumn(name = "situacao_aprendizagem_id", referencedColumnName = "situacao_aprendizagem_id")
	private SituacaoAprendizagem situacaoAprendizagemId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CopetenciaIndicador getCopetenciaIndicadorId() {
		return copetenciaIndicadorId;
	}
	public void setCopetenciaIndicadorId(CopetenciaIndicador copetenciaIndicadorId) {
		this.copetenciaIndicadorId = copetenciaIndicadorId;
	}
	public SituacaoAprendizagem getSituacaoAprendizagemId() {
		return situacaoAprendizagemId;
	}
	public void setSituacaoAprendizagemId(SituacaoAprendizagem situacaoAprendizagemId) {
		this.situacaoAprendizagemId = situacaoAprendizagemId;
	}

}
