package br.com.senac.model.dtos;

import java.util.List;

import br.com.senac.model.Atividade;
import br.com.senac.model.Badge;
import br.com.senac.model.CopetenciaIndicador;
import br.com.senac.model.GrauDificuldade;
import br.com.senac.model.ObjetoAprendizagem;
import br.com.senac.model.PlanejamentoUc;
import br.com.senac.model.Enums.SituacaoAprendizagemOrdem;
import br.com.senac.model.Enums.SituacaoAprendizagemStatus;

public class SituacaoAprendizagemDTO {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private SituacaoAprendizagemOrdem ordem;
	private SituacaoAprendizagemStatus status;
	private PlanejamentoUc planejamentoUcId;
	private GrauDificuldade grauDificuldadeId;
	private Badge badgeId;
	private List<Atividade> atividades;
	private List<CopetenciaIndicador> indicadores;
	private List<ObjetoAprendizagem> objetos;

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
	public PlanejamentoUc getPlanejamentoUcId() {
		return planejamentoUcId;
	}
	public void setPlanejamentoUcId(PlanejamentoUc planejamentoUcId) {
		this.planejamentoUcId = planejamentoUcId;
	}
	public GrauDificuldade getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(GrauDificuldade grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Badge getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(Badge badgeId) {
		this.badgeId = badgeId;
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	public List<CopetenciaIndicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<CopetenciaIndicador> indicadores) {
		this.indicadores = indicadores;
	}
	public List<ObjetoAprendizagem> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<ObjetoAprendizagem> objetos) {
		this.objetos = objetos;
	}
	
	
}
