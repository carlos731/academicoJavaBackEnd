package br.com.senac.model.dtos;

import java.util.List;

import br.com.senac.model.Copetencia;
import br.com.senac.model.SituacaoAprendizagem;

public class CopetenciaIndicadorDTO {
	
	private Integer id;
	private String descricao;
	private Integer status;
	private Copetencia copetenciaId;
	private List<SituacaoAprendizagem> situacoesAprendizagens;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Copetencia getCopetenciaId() {
		return copetenciaId;
	}
	public void setCopetenciaId(Copetencia copetenciaId) {
		this.copetenciaId = copetenciaId;
	}
	public List<SituacaoAprendizagem> getSituacoesAprendizagens() {
		return situacoesAprendizagens;
	}
	public void setSituacoesAprendizagens(List<SituacaoAprendizagem> situacoesAprendizagens) {
		this.situacoesAprendizagens = situacoesAprendizagens;
	}
	
}
