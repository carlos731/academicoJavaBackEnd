package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

public class IndicadorSituacaoAprendizagemRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO COPETENCIA INDICADOR DEVE SER PREENCHIDO!!")
	private Integer copetenciaIndicadorId;
	@NotNull(message = "O CAMPO SITUACAO APRENDIZAGEM DEVE SER PREENCHIDO!!")
	private Integer situacaoAprendizagemId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCopetenciaIndicadorId() {
		return copetenciaIndicadorId;
	}
	public void setCopetenciaIndicadorId(Integer copetenciaIndicadorId) {
		this.copetenciaIndicadorId = copetenciaIndicadorId;
	}
	public Integer getSituacaoAprendizagemId() {
		return situacaoAprendizagemId;
	}
	public void setSituacaoAprendizagemId(Integer situacaoAprendizagemId) {
		this.situacaoAprendizagemId = situacaoAprendizagemId;
	}
	
}
