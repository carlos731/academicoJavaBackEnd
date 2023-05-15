package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

public class ModuloRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO CARGA HORÁRIA DEVE SER PREENCHIDO!!")	
	private Integer cargaHoraria;
	@NotNull(message = "O CAMPO OFERTA DEVE SER PREENCHIDO!!")
	private Integer ofertaId;

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
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Integer getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Integer ofertaId) {
		this.ofertaId = ofertaId;
	}

}
