package br.com.senac.model.dtos;

import java.time.LocalDate;

import br.com.senac.model.Grupo;

public class PlanejamentoUcDTO {
	
	private Integer id;
	private String descricao;
	private LocalDate dataAprovacao = LocalDate.now();
	private Integer status; 
	private Grupo grupoId;
	
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
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
		this.grupoId = grupoId;
	}
}
