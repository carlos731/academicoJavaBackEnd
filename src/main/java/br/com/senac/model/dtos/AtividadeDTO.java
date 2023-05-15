package br.com.senac.model.dtos;

import java.time.LocalDate;
import java.util.List;

import br.com.senac.model.Arquivo;
import br.com.senac.model.AtividadeTipo;
import br.com.senac.model.GrauDificuldade;
import br.com.senac.model.SituacaoAprendizagem;
import br.com.senac.model.Enums.AtividadeOrdem;
import br.com.senac.model.Enums.AtividadeStatus;

public class AtividadeDTO {
	
	private Integer id;
	private String descricao;
	private LocalDate dataInicio = LocalDate.now();
	private Integer duracaoMinutos;
	private AtividadeOrdem ordem;
	private AtividadeStatus status;
	private SituacaoAprendizagem situacaoAprendizagemId;
	private AtividadeTipo atividadePorId;
	private GrauDificuldade grauDificuldadeId;
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
