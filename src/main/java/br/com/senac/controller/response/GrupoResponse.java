package br.com.senac.controller.response;

import java.time.LocalDate;
import java.util.List;

import br.com.senac.model.Participante;
import br.com.senac.model.Periodo;
import br.com.senac.model.Professor;
import br.com.senac.model.Turno;
import br.com.senac.model.UnidadeCurricular;

public class GrupoResponse {
	
	private Integer id;
	private String descricao;
	private LocalDate inicio = LocalDate.now();
	private LocalDate fim = LocalDate.now();
	private String sala;
	private Integer status;
	private Turno turnoId;
	private UnidadeCurricular unidadeCurricularId;
	private Periodo periodoId;
	private Professor professorId;
	private List<Participante> participantes;
	
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
	public Turno getTurnoId() {
		return turnoId;
	}
	public void setTurnoId(Turno turnoId) {
		this.turnoId = turnoId;
	}
	public UnidadeCurricular getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(UnidadeCurricular unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	public Periodo getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Periodo periodoId) {
		this.periodoId = periodoId;
	}
	public Professor getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Professor professorId) {
		this.professorId = professorId;
	}
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
}
