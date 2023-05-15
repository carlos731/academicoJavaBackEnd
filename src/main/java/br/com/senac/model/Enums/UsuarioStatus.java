package br.com.senac.model.Enums;

public enum UsuarioStatus {

	ATIVO(0, "ATIVO"), INATIVO(1, "INATIVO"), TRANCADO(2, "TRANCADO"), CANCELADO(3, "CANCELADO"); 

	private Integer codigo;
	private String descricao;
	
	private UsuarioStatus(Integer codigo, String descricao) {
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
	
	public static UsuarioStatus toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(UsuarioStatus x : UsuarioStatus.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo usuário inválido");
	}
}
