package br.com.senac.controller.request;

public class ScoreNivelRequest {
	private Integer id;
	private Integer valorMin;
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
