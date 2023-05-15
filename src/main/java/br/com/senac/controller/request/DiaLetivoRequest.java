package br.com.senac.controller.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DiaLetivoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DIA LETIVO DEVE SER PREENCHIDO!!!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date diaLetivo;
	@NotNull(message = "O CAMPO DIA DEVE SER PREENCHIDO!!!")
	private Integer diaLetivoDia;
	@NotNull(message = "O CAMPO MES DEVE SER PREENCHIDO!!!")
	private Integer diaLetivoMes;
	@NotNull(message = "O CAMPO ANO DEVE SER PREENCHIDO!!!")
	private Integer diaLetivoAno;
	@NotNull(message = "O CAMPO SEMANA DEVE SER PREENCHIDO!!!")
	private Integer diaLetivoSemana;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!!")
	private Integer diaLetivoStatus;
	@NotNull(message = "O CAMPO PERIODO DEVE SER PREENCHIDO!!!")
	private Integer periodoId;
	
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
	public Integer getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Integer periodoId) {
		this.periodoId = periodoId;
	}
	
}
