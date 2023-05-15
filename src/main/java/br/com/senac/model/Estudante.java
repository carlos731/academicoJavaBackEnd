package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.Enums.EstudanteStatus;

@Entity
@Table(name = "estudante")
public class Estudante implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estudante_id")
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_trancamento")
	private LocalDate dataTrancamento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_formatura")
	private LocalDate dataFormatura;
	@Column(name = "status")
	private EstudanteStatus status;
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private Usuario usuarioId;
	@OneToOne
	@JoinColumn(name = "oferta_id", referencedColumnName = "oferta_id")
	private Oferta ofertaId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDate getDataTrancamento() {
		return dataTrancamento;
	}
	public void setDataTrancamento(LocalDate dataTrancamento) {
		this.dataTrancamento = dataTrancamento;
	}
	public LocalDate getDataFormatura() {
		return dataFormatura;
	}
	public void setDataFormatura(LocalDate dataFormatura) {
		this.dataFormatura = dataFormatura;
	}
	public EstudanteStatus getStatus() {
		return status;
	}
	public void setStatus(EstudanteStatus status) {
		this.status = status;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Oferta getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Oferta ofertaId) {
		this.ofertaId = ofertaId;
	}

}
