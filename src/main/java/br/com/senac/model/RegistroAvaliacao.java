package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senac.model.Enums.RegistroAvaliacaoStatus;

@Entity
@Table(name = "registro_avaliacao")
public class RegistroAvaliacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registro_avaliacao_id")
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "registro_avaliacao_data")
	private LocalDate data = LocalDate.now();
	@Column(name = "registro_avaliacao_status")
	private RegistroAvaliacaoStatus status;
	@OneToOne
	@JoinColumn(name = "avaliacao_tipo_id", referencedColumnName = "avaliacao_tipo_id")
	private AvaliacaoTipo avaliacaoTipoId;
	@ManyToOne
	@JoinColumn(name = "participante_id", referencedColumnName = "participante_id")
	private Participante participanteId;
	@OneToOne
	@JoinColumn(name = "avaliacao_conceito_id", referencedColumnName = "avaliacao_conceito_id")
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
