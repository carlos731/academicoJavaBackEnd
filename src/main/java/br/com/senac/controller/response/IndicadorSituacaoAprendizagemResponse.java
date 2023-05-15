package br.com.senac.controller.response;

import br.com.senac.model.CopetenciaIndicador;
import br.com.senac.model.SituacaoAprendizagem;

public class IndicadorSituacaoAprendizagemResponse {
	
	private Integer id;
	private CopetenciaIndicador copetenciaIndicadorId;
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
