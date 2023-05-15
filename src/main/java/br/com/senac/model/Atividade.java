package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senac.model.Enums.AtividadeOrdem;
import br.com.senac.model.Enums.AtividadeStatus;

@Entity
@Table(name = "atividade")
public class Atividade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atividade_id")
	private Integer id;
	@Column(name = "atividade_descricao")
	private String descricao;
	@Column(name = "atividade_data_inicio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio = LocalDate.now();
	@Column(name = "atividade_duracao_minutos")
	private Integer duracaoMinutos;
	@Column(name = "atividade_ordem")
	private AtividadeOrdem ordem;
	@Column(name = "atividade_status")
	private AtividadeStatus status;
	@ManyToOne
	@JoinColumn(name = "situacao_aprendizagem_id", referencedColumnName = "situacao_aprendizagem_id")
	private SituacaoAprendizagem situacaoAprendizagemId;
	@OneToOne
	@JoinColumn(name = "atividade_tipo_id", referencedColumnName = "atividade_tipo_id")
	private AtividadeTipo atividadePorId;
	@OneToOne
	@JoinColumn(name = "grau_dificuldade_id", referencedColumnName = "grau_dificuldade_id")
	private GrauDificuldade grauDificuldadeId;
	@JsonIgnore
	@ManyToMany(mappedBy = "atividades")
	private List<Arquivo> arquivos;
	
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
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}
	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}
	public AtividadeOrdem getOrdem() {
		return ordem;
	}
	public void setOrdem(AtividadeOrdem ordem) {
		this.ordem = ordem;
	}
	public AtividadeStatus getStatus() {
		return status;
	}
	public void setStatus(AtividadeStatus status) {
		this.status = status;
	}
	public SituacaoAprendizagem getSituacaoAprendizagemId() {
		return situacaoAprendizagemId;
	}
	public void setSituacaoAprendizagemId(SituacaoAprendizagem situacaoAprendizagemId) {
		this.situacaoAprendizagemId = situacaoAprendizagemId;
	}
	public AtividadeTipo getAtividadePorId() {
		return atividadePorId;
	}
	public void setAtividadePorId(AtividadeTipo atividadePorId) {
		this.atividadePorId = atividadePorId;
	}
	public GrauDificuldade getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(GrauDificuldade grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public List<Arquivo> getArquivos() {
		return arquivos;
	}
	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	
	
}
