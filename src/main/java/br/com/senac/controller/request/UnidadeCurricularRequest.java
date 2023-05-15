package br.com.senac.controller.request;

public class UnidadeCurricularRequest {
	
	private Integer id;
	private String codigo;
	private String nome;
	private String nomeCurto;
	private Integer horas;
	private Integer modulo;
	private Integer ordem;
	private Integer status;
	private Integer moduloId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCurto() {
		return nomeCurto;
	}
	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Integer getModulo() {
		return modulo;
	}
	public void setModulo(Integer modulo) {
		this.modulo = modulo;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getModuloId() {
		return moduloId;
	}
	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
	}

	
	
}
