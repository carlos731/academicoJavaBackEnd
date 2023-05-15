package br.com.senac.controller.response;

import java.time.LocalDate;

import br.com.senac.model.AvaliacaoConceito;
import br.com.senac.model.AvaliacaoTipo;
import br.com.senac.model.Participante;
import br.com.senac.model.Enums.RegistroAvaliacaoStatus;

public class RegistroAvaliacaoResponse {
	
	private Integer id;
	private LocalDate data = LocalDate.now();
	private RegistroAvaliacaoStatus status;
	private AvaliacaoTipo avaliacaoTipoId;
	private Participante participanteId;
	private AvaliacaoConceito avaliacaoConceitoId;
	
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
	public AvaliacaoTipo getAvaliacaoTipoId() {
		return avaliacaoTipoId;
	}
	public void setAvaliacaoTipoId(AvaliacaoTipo avaliacaoTipoId) {
		this.avaliacaoTipoId = avaliacaoTipoId;
	}
	public Participante getParticipanteId() {
		return participanteId;
	}
	public void setParticipanteId(Participante participanteId) {
		this.participanteId = participanteId;
	}
	public AvaliacaoConceito getAvaliacaoConceitoId() {
		return avaliacaoConceitoId;
	}
	public void setAvaliacaoConceitoId(AvaliacaoConceito avaliacaoConceitoId) {
		this.avaliacaoConceitoId = avaliacaoConceitoId;
	}
}
