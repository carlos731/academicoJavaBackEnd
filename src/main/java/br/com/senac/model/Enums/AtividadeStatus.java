package br.com.senac.model.Enums;

public enum AtividadeStatus {
	
	ATIVO(0, "ATIVO"), INATIVO(1, "INATIVO"), TRANCADO(2, "TRANCADO"), CANCELADO(3, "CANCELADO"); 

	private Integer codigo;
	private String descricao;
	
	private AtividadeStatus(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
