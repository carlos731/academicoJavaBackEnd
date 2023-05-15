package br.com.senac.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class PlanejamentoUcRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRICAO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO DATA APROVACAO DEVE SER PREENCHIDO!!")
	private LocalDate dataAprovacao = LocalDate.now();
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	@NotNull(message = "O CAMPO GRUPO DEVE SER PREENCHIDO!!")
	private Integer grupoId;
	
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
	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}
	public void setDataAprovacao(LocalDate dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
	
}
