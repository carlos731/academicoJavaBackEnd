package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudante_score")
public class EstudanteScore implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estudante_score_id")
	private Integer id;
	@Column(name = "estudante_score_valor")
	private String valor;
	@ManyToOne
	@JoinColumn(name = "estudante_id", referencedColumnName = "estudante_id")
	private Estudante estudanteId;
	@OneToOne
	@JoinColumn(name = "score_nivel_id", referencedColumnName = "score_nivel_id")
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
