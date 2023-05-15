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

import br.com.senac.model.Enums.Status;

@Entity
@Table(name = "senac_coin_movimentacao")
public class SenacCoinMovimentacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "senac_coin_movimentacao_id")
	private Integer id;
	@Column(name = "senac_coin_movimentacao_data")
	private Date data = new Date();
	@Column(name = "senac_coin_movimentacao_observacao", columnDefinition = "LONGTEXT")
	private String observacao;
	@Column(name = "senac_coin_movimentacao_valor")
	private Long valor;
	@Column(name = "senac_coin_movimentacao_status")
	private Status status;
	@ManyToOne
	@JoinColumn(name = "senac_coin_id", referencedColumnName = "senac_coin_id")
	private SenacCoin senacCoinId;
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private Usuario usuarioId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public SenacCoin getSenacCoinId() {
		return senacCoinId;
	}
	public void setSenacCoinId(SenacCoin senacCoinId) {
		this.senacCoinId = senacCoinId;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

}
