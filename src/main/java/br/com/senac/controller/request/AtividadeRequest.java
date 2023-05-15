package br.com.senac.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.Enums.AtividadeOrdem;
import br.com.senac.model.Enums.AtividadeStatus;

public class AtividadeRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO DATA INICIO DEVE SER PREENCHIDO!!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio = LocalDate.now();
	@NotNull(message = "O CAMPO DURACAO DEVE SER PREENCHIDO!!")
	private Integer duracaoMinutos;
	@NotNull(message = "O CAMPO ORDEM DEVE SER PREENCHIDO!!")
	private AtividadeOrdem ordem;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private AtividadeStatus status;
	@NotNull(message = "O CAMPO SITUAÇÃO APRENDIZAGEM DEVE SER PREENCHIDO!!")
	private Integer situacaoAprendizagemId;
	@NotNull(message = "O CAMPO AVALIAÇÃO TIPO DEVE SER PREENCHIDO!!")
	private Integer atividadeTipoId;
	@NotNull(message = "O CAMPO GRAU DIFICULDADE DEVE SER PREENCHIDO!!")
	private Integer grauDificuldadeId;
	
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
	public Integer getSituacaoAprendizagemId() {
		return situacaoAprendizagemId;
	}
	public void setSituacaoAprendizagemId(Integer situacaoAprendizagemId) {
		this.situacaoAprendizagemId = situacaoAprendizagemId;
	}
	public Integer getAtividadeTipoId() {
		return atividadeTipoId;
	}
	public void setAtividadeTipoId(Integer atividadeTipoId) {
		this.atividadeTipoId = atividadeTipoId;
	}
	public Integer getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(Integer grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	
	
	
	
}
