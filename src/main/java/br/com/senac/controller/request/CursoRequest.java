package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.CursoStatus;

public class CursoRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO NOME DEVE SER PREENCHIDO!!")
	private String nome;
	@NotNull(message = "O CAMPO CODIGO DEVE SER PREENCHIDO!!")
	private String codigo;
	@NotNull(message = "O CAMPO TIPO DEVE SER PREENCHIDO!!")
	private Integer cursoTipoId;
	@NotNull(message = "O CAMPO HORAS DEVE SER PREENCHIDO!!")
	private Integer horas;
	//@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private CursoStatus status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getCursoTipoId() {
		return cursoTipoId;
	}
	public void setCursoTipoId(Integer cursoTipoId) {
		this.cursoTipoId = cursoTipoId;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public CursoStatus getStatus() {
		return status;
	}
	public void setStatus(CursoStatus status) {
		this.status = status;
	}
	
	
}
