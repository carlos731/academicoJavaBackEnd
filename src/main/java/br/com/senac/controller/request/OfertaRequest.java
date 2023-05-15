package br.com.senac.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class OfertaRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO!")
	private String descricao;
	@NotNull(message = "O CAMPO CODIGO DEVE SER PREENCHIDO!")
	private String codigo;
	@NotNull(message = "O CAMPO INICIO_OPERACAO DEVE SER PREENCHIDO!")
	private LocalDate inicioOperacao = LocalDate.now();
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!")
	private Integer status;
	@NotNull(message = "O CAMPO CURSO_ID DEVE SER PREENCHIDO!")
	private Integer cursoId;
	
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
	public Integer getCursoId() {
		return cursoId;
	}
	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}
	
}
