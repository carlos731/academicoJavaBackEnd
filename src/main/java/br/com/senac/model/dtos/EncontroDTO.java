package br.com.senac.model.dtos;

import java.util.Date;

import br.com.senac.model.DiaLetivo;
import br.com.senac.model.EncontroTipo;
import br.com.senac.model.Grupo;
import br.com.senac.model.Enums.EncontroStatus;

public class EncontroDTO {
	
	private Integer id;
	private String observacao;
	private DiaLetivo diaLetivoId;
	private Grupo grupoId;
	private Date dataInicio;
	private Date dataFim;
	private String local;
	private EncontroStatus status;
	private EncontroTipo encontroTipoId;
	
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
	public DiaLetivo getDiaLetivoId() {
		return diaLetivoId;
	}
	public void setDiaLetivoId(DiaLetivo diaLetivoId) {
		this.diaLetivoId = diaLetivoId;
	}
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
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
	public EncontroTipo getEncontroTipoId() {
		return encontroTipoId;
	}
	public void setEncontroTipoId(EncontroTipo encontroTipoId) {
		this.encontroTipoId = encontroTipoId;
	}
}
