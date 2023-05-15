package br.com.senac.controller.response;

import java.util.List;

import br.com.senac.model.Oferta;
import br.com.senac.model.UnidadeCurricular;

public class ModuloResponse {
	
	private Integer id;	
	private String descricao;
	private Integer cargaHoraria;
	private Oferta ofertaId;
	private List<UnidadeCurricular> unidadeCurriculares;

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
	public Oferta getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Oferta ofertaId) {
		this.ofertaId = ofertaId;
	}
	public List<UnidadeCurricular> getUnidadeCurriculares() {
		return unidadeCurriculares;
	}
	public void setUnidadeCurriculares(List<UnidadeCurricular> unidadeCurriculares) {
		this.unidadeCurriculares = unidadeCurriculares;
	}

}
