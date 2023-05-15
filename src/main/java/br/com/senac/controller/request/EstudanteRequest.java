package br.com.senac.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.Enums.EstudanteStatus;

public class EstudanteRequest {
	
	private Integer id;
	//@NotNull(message = "O CAMPO DATA CADASTRO PRECISA SER PREENCHIDO!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataTrancamento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFormatura;
	@NotNull(message = "O CAMPO STATUS PRECISA SER PREENCHIDO!")
	private EstudanteStatus status;
	@NotNull(message = "O CAMPO USUARIO PRECISA SER PREENCHIDO!")
	private Integer usuarioId;
	@NotNull(message = "O CAMPO OFERTA PRECISA SER PREENCHIDO!")
	private Integer ofertaId;

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
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Integer ofertaId) {
		this.ofertaId = ofertaId;
	}

}
