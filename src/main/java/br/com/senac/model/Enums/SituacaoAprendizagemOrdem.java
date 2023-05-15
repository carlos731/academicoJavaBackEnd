package br.com.senac.model.Enums;

public enum SituacaoAprendizagemOrdem {
	
	INSUFICIENTE(0, "INSUFICIENTE"), SUFICIENTE(1, "SUFICIENTE"), BOM(2, "BOM"), OTIMO(3, "OTIMO"); 

	private Integer codigo;
	private String descricao;
	
	private SituacaoAprendizagemOrdem(Integer codigo, String descricao) {
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
