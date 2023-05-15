package br.com.senac.model.dtos;

import br.com.senac.model.Enums.AvaliacaoConceitoStatus;

public class AvaliacaoConceitoDTO {
	
	private Integer id;
	private String descricao;
	private Integer valorMin;
	private Integer valorMax;
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
