package br.com.senac.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.Enums.RegistroAvaliacaoStatus;

public class RegistroAvaliacaoRequest {
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private RegistroAvaliacaoStatus status;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private Integer avaliacaoTipoId;
	@NotNull(message = "O CAMPO AVALIACAO TIPO DEVE SER PREENCHIDO!!")
	private Integer participanteId;
	@NotNull(message = "O CAMPO AVALIACAO CONCEITO DEVE SER PREENCHIDO!!")
	private Integer avaliacaoConceitoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public RegistroAvaliacaoStatus getStatus() {
		return status;
	}
	public void setStatus(RegistroAvaliacaoStatus status) {
		this.status = status;
	}
	public Integer getAvaliacaoTipoId() {
		return avaliacaoTipoId;
	}
	public void setAvaliacaoTipoId(Integer avaliacaoTipoId) {
		this.avaliacaoTipoId = avaliacaoTipoId;
	}
	public Integer getParticipanteId() {
		return participanteId;
	}
	public void setParticipanteId(Integer participanteId) {
		this.participanteId = participanteId;
	}
	public Integer getAvaliacaoConceitoId() {
		return avaliacaoConceitoId;
	}
	public void setAvaliacaoConceitoId(Integer avaliacaoConceitoId) {
		this.avaliacaoConceitoId = avaliacaoConceitoId;
	}
	
}
