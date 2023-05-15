package br.com.senac.controller.response;

import java.time.LocalDate;

import br.com.senac.model.Oferta;
import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.EstudanteStatus;

public class EstudanteResponse {
	
	private Integer id;
	private LocalDate dataCadastro = LocalDate.now();
	private LocalDate dataTrancamento;
	private LocalDate dataFormatura;
	private EstudanteStatus status;
	private Usuario usuarioId;
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
