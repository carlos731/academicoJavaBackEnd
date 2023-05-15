package br.com.senac.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senac.model.Enums.SituacaoAprendizagemOrdem;
import br.com.senac.model.Enums.SituacaoAprendizagemStatus;

@Entity
@Table(name = "situacao_aprendizagem")
public class SituacaoAprendizagem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "situacao_aprendizagem_id")
	private Integer id;
	@Column(name = "situacao_aprendizagem_titulo")
	private String titulo;
	@Column(name = "situacao_aprendizagem_descricao")
	private String descricao;
	@Column(name = "situacao_aprendizagem_ordem")
	private SituacaoAprendizagemOrdem ordem;
	@Column(name = "situacao_aprendizagem_status")
	private SituacaoAprendizagemStatus status;
	@ManyToOne
	@JoinColumn(name = "planejamento_uc_id", referencedColumnName = "planejamento_uc_id")
	private PlanejamentoUc planejamentoUcId;
	@OneToOne
	@JoinColumn(name = "grau_dificuldade_id", referencedColumnName = "grau_dificuldade_id")
	private GrauDificuldade grauDificuldadeId;
	@OneToOne
	@JoinColumn(name = "badge_id", referencedColumnName = "badge_id")
	private Badge badgeId;
	@JsonIgnore
	@OneToMany(mappedBy = "situacaoAprendizagemId")
	private List<Atividade> atividades;
	@ManyToMany
	@JoinTable(
		name = "indicador_situacao_aprendizagens",
		joinColumns = { @JoinColumn(name = "situacao_aprendizagem_id", referencedColumnName = "situacao_aprendizagem_id")},
		inverseJoinColumns = { @JoinColumn(name = "copetencia_indicador_id", referencedColumnName = "copetencia_indicador_id")} 
	)
	@Column(name = "indicadores")
	private List<CopetenciaIndicador> indicadores;
	@JsonIgnore
	@ManyToMany(mappedBy = "aprendizagens")
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
	public List<CopetenciaIndicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<CopetenciaIndicador> indicadores) {
		this.indicadores = indicadores;
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	public List<ObjetoAprendizagem> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<ObjetoAprendizagem> objetos) {
		this.objetos = objetos;
	}
	

}
