package br.com.senac.controller.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.senac.model.Enums.EncontroStatus;

public class EncontroRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO OBSERVAÇÃO DEVE SER PREENCHIDO!!")
	private String observacao;
	@NotNull(message = "O CAMPO DIA LETIVO DEVE SER PREENCHIDO!!")
	private Integer diaLetivoId;
	@NotNull(message = "O CAMPO GRUPo DEVE SER PREENCHIDO!!")
	private Integer grupoId;
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "O CAMPO DATA INICIO DEVE SER PREENCHIDO!!")
	private Date dataInicio;
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "O CAMPO DATA FIM DEVE SER PREENCHIDO!!")
	private Date dataFim;
	@NotNull(message = "O CAMPO LOCAL DEVE SER PREENCHIDO!!")
	private String local;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private EncontroStatus status;
	@NotNull(message = "O CAMPO ENCONTRO DEVE SER PREENCHIDO!!")
	private Integer encontroTipoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getDiaLetivoId() {
		return diaLetivoId;
	}
	public void setDiaLetivoId(Integer diaLetivoId) {
		this.diaLetivoId = diaLetivoId;
	}
	public Integer getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public EncontroStatus getStatus() {
		return status;
	}
	public void setStatus(EncontroStatus status) {
		this.status = status;
	}
	public Integer getEncontroTipoId() {
		return encontroTipoId;
	}
	public void setEncontroTipoId(Integer encontroTipoId) {
		this.encontroTipoId = encontroTipoId;
	}
	
}
