package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score_nivel")
public class ScoreNivel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "score_nivel_id")
	private Integer id;
	@Column(name = "score_nivel_min")
	private Integer valorMin;
	@Column(name = "score_nivel_max")
	private Integer valorMax;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getValorMin() {
		return valorMin;
	}
	public void setValorMin(Integer valorMin) {
		this.valorMin = valorMin;
	}
	public Integer getValorMax() {
		return valorMax;
	}
	public void setValorMax(Integer valorMax) {
		this.valorMax = valorMax;
	}
	
	
}
