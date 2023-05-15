package br.com.senac.controller.response;

import java.time.LocalDate;

import br.com.senac.model.Curso;

public class OfertaResponse {
	
	private Integer id;
	private String descricao;
	private String codigo;
	private LocalDate inicioOperacao = LocalDate.now();
	private Integer status;
	private Curso cursoId;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getInicioOperacao() {
		return inicioOperacao;
	}
	public void setInicioOperacao(LocalDate inicioOperacao) {
		this.inicioOperacao = inicioOperacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Curso getCursoId() {
		return cursoId;
	}
	public void setCursoId(Curso cursoId) {
		this.cursoId = cursoId;
	}
}
