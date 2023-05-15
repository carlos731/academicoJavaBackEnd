package br.com.senac.model.dtos;

import java.util.Date;

import br.com.senac.model.Periodo;

public class DiaLetivoDTO {
	
	private Integer id;
	private Date diaLetivo;
	private Integer diaLetivoDia;
	private Integer diaLetivoMes;
	private Integer diaLetivoAno;
	private Integer diaLetivoSemana;
	private Integer diaLetivoStatus;
	private Periodo periodoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDiaLetivo() {
		return diaLetivo;
	}
	public void setDiaLetivo(Date diaLetivo) {
		this.diaLetivo = diaLetivo;
	}
	public Integer getDiaLetivoDia() {
		return diaLetivoDia;
	}
	public void setDiaLetivoDia(Integer diaLetivoDia) {
		this.diaLetivoDia = diaLetivoDia;
	}
	public Integer getDiaLetivoMes() {
		return diaLetivoMes;
	}
	public void setDiaLetivoMes(Integer diaLetivoMes) {
		this.diaLetivoMes = diaLetivoMes;
	}
	public Integer getDiaLetivoAno() {
		return diaLetivoAno;
	}
	public void setDiaLetivoAno(Integer diaLetivoAno) {
		this.diaLetivoAno = diaLetivoAno;
	}
	public Integer getDiaLetivoSemana() {
		return diaLetivoSemana;
	}
	public void setDiaLetivoSemana(Integer diaLetivoSemana) {
		this.diaLetivoSemana = diaLetivoSemana;
	}
	public Integer getDiaLetivoStatus() {
		return diaLetivoStatus;
	}
	public void setDiaLetivoStatus(Integer diaLetivoStatus) {
		this.diaLetivoStatus = diaLetivoStatus;
	}
	public Periodo getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Periodo periodoId) {
		this.periodoId = periodoId;
	}
}
