package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

public class PeriodoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO NOME DEVE SER PREENCHIDO!!")
	private String nome;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
