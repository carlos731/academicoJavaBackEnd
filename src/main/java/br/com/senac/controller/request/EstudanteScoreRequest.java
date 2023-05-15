package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

public class EstudanteScoreRequest {
	@NotNull(message = "CAMPO VALOR DEVE SER PREENCHIDO!!!")
	private String valor;
	@NotNull(message = "CAMPO ESTUDANTE DEVE SER PREENCHIDO!!!")
	private Integer estudanteId;
	@NotNull(message = "CAMPO SCORENIVEL DEVE SER PREENCHIDO!!!")
	private Integer scoreNivelId;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Integer getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Integer estudanteId) {
		this.estudanteId = estudanteId;
	}
	public Integer getScoreNivelId() {
		return scoreNivelId;
	}
	public void setScoreNivelId(Integer scoreNivelId) {
		this.scoreNivelId = scoreNivelId;
	}
}
