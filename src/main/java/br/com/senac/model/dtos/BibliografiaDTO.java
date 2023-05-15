package br.com.senac.model.dtos;

import br.com.senac.model.UnidadeCurricular;
import br.com.senac.model.Enums.BibliografiaStatus;

public class BibliografiaDTO {
	
	private Integer id;
	private String nome;
	private BibliografiaStatus status;
	private UnidadeCurricular  unidadeCurricularId;

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
	public BibliografiaStatus getStatus() {
		return status;
	}
	public void setStatus(BibliografiaStatus status) {
		this.status = status;
	}
	public UnidadeCurricular getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(UnidadeCurricular unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	
}
