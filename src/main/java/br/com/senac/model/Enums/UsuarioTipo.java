package br.com.senac.model.Enums;

public enum UsuarioTipo {
	
	ADMIN(0, "ROLE_ADMIN"), PROFESSOR(1, "ROLE_PROFESSOR"), ESTUDANTE(2, "ROLE_ESTUDANTE"), COLABORADOR(3, "ROLE_COLABORADOR"); 

	private Integer codigo;
	private String descricao;
	
	private UsuarioTipo(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static UsuarioTipo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(UsuarioTipo x : UsuarioTipo.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo usuário inválido");
	}
	
	
}
