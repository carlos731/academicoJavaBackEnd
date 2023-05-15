package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.senac.model.Enums.AvaliacaoConceitoStatus;

@Entity
@Table(name = "avaliacao_conceito")
public class AvaliacaoConceito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "avaliacao_conceito_id")
	private Integer id;
	@Column(name = "avaliacao_conceito_descricao")
	private String descricao;
	@Column(name = "avaliacao_conceito_valor_min")
	private Integer valorMin;
	@Column(name = "avaliacao_conceito_valor_max")
	private Integer valorMax;
	@Column(name = "avaliacao_conceito_status")
	private AvaliacaoConceitoStatus status;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getValorMin() {
		return valorMin;
	}
	public void setValorMin(Integer valorMin) {
		this.valorMin = valorMin;
	}
	public Integer getValorMax() {
		return valorMax;
	}
	public void setValorMax(Integer valorMax) {
		this.valorMax = valorMax;
	}
	public AvaliacaoConceitoStatus getStatus() {
		return status;
	}
	public void setStatus(AvaliacaoConceitoStatus status) {
		this.status = status;
	}

}
