package br.com.senac.controller.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Participante;

public class GrupoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO GRUPO_INICO DEVE SER PREENCHIDO!!")
	private LocalDate inicio = LocalDate.now();
	
	private LocalDate fim = LocalDate.now();
	@NotNull(message = "O CAMPO GRUPO_SALA DEVE SER PREENCHIDO!!")
	private String sala;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer status;
	@NotNull(message = "O CAMPO TURNO DEVE SER PREENCHIDO!!")
	private Integer turnoId;
	@NotNull(message = "O CAMPO UNIDADE CURRICULAR DEVE SER PREENCHIDO!!")
	private Integer unidadeCurricularId;
	@NotNull(message = "O CAMPO PERIODO DEVE SER PREENCHIDO!!")
	private Integer periodoId;
	@NotNull(message = "O CAMPO PROFESSOR DEVE SER PREENCHIDO!!")
	private Integer professorId;
	private List<Participante> participante;//Tirar depois
	
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
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTurnoId() {
		return turnoId;
	}
	public void setTurnoId(Integer turnoId) {
		this.turnoId = turnoId;
	}
	public Integer getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(Integer unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	public Integer getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Integer periodoId) {
		this.periodoId = periodoId;
	}
	public Integer getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}
	public List<Participante> getParticipante() {
		return participante;
	}
	public void setParticipante(List<Participante> participante) {
		this.participante = participante;
	}
	
}
