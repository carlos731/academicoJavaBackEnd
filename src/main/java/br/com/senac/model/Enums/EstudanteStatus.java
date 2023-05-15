package br.com.senac.model.Enums;

public enum EstudanteStatus {
	
	ATIVO(0, "ESTUDANDO"), INATIVO(1, "FORMATURA"), TRANCADO(2, "TRANCADO"); 

	private Integer codigo;
	private String descricao;
	
	private EstudanteStatus(Integer codigo, String descricao) {
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
