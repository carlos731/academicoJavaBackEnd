package br.com.senac.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.senac.model.Enums.EncontroStatus;

@Entity
@Table(name = "encontro")
public class Encontro implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "encontro_id")
	private Integer id;
	@Column(name = "encontro_observacao")
	private String observacao;
	@OneToOne
	@JoinColumn(name = "dia_letivo_id", referencedColumnName = "dia_letivo_id")
	private DiaLetivo diaLetivoId;
	@ManyToOne
	@JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
	private Grupo grupoId;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "encontro_data_inicio")
	private Date dataInicio;
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "encontro_data_fim")
	private Date dataFim;
	@Column(name = "encontro_local")
	private String local;
	@Column(name = "encontro_status")
	private EncontroStatus status;
	@OneToOne
	@JoinColumn(name = "encontro_tipo_id", referencedColumnName = "encontro_tipo_id")
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
