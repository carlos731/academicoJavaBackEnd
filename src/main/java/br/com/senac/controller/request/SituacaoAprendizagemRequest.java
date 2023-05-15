package br.com.senac.controller.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.senac.model.CopetenciaIndicador;
import br.com.senac.model.Enums.SituacaoAprendizagemOrdem;
import br.com.senac.model.Enums.SituacaoAprendizagemStatus;

public class SituacaoAprendizagemRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO TITULO DEVE SER PREENCHIDO!!")
	private String titulo;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO ORDEM DEVE SER PREENCHIDO!!")
	private SituacaoAprendizagemOrdem ordem;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private SituacaoAprendizagemStatus status;
	@NotNull(message = "O CAMPO PLANEJAMENTO DEVE SER PREENCHIDO!!")
	private Integer planejamentoUcId;
	@NotNull(message = "O CAMPO GRAU DIFICULDADE DEVE SER PREENCHIDO!!")
	private Integer grauDificuldadeId;
	@NotNull(message = "O CAMPO BADGE DEVE SER PREENCHIDO!!")
	private Integer badgeId;
	@NotNull(message = "O CAMPO INDICADORES DEVE SER PREENHICO!!")
	private List<CopetenciaIndicador> indicadores;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public SituacaoAprendizagemOrdem getOrdem() {
		return ordem;
	}
	public void setOrdem(SituacaoAprendizagemOrdem ordem) {
		this.ordem = ordem;
	}
	public SituacaoAprendizagemStatus getStatus() {
		return status;
	}
	public void setStatus(SituacaoAprendizagemStatus status) {
		this.status = status;
	}
	public Integer getPlanejamentoUcId() {
		return planejamentoUcId;
	}
	public void setPlanejamentoUcId(Integer planejamentoUcId) {
		this.planejamentoUcId = planejamentoUcId;
	}
	public Integer getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(Integer grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Integer getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(Integer badgeId) {
		this.badgeId = badgeId;
	}
	public List<CopetenciaIndicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<CopetenciaIndicador> indicadores) {
		this.indicadores = indicadores;
	}

}
