package br.com.senac.model.dtos;

import br.com.senac.model.Estudante;
import br.com.senac.model.ScoreNivel;

public class EstudanteScoreDTO {
	
	private Integer id;
	private String valor;
	private Estudante estudanteId;
	private ScoreNivel scoreNivelId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Estudante getEstudanteId() {
		return estudanteId;
	}
	public void setEstudanteId(Estudante estudanteId) {
		this.estudanteId = estudanteId;
	}
	public ScoreNivel getScoreNivelId() {
		return scoreNivelId;
	}
	public void setScoreNivelId(ScoreNivel scoreNivelId) {
		this.scoreNivelId = scoreNivelId;
	}
}
