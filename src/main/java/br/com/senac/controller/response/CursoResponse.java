package br.com.senac.controller.response;

import java.util.List;

import br.com.senac.model.CursoTipo;
import br.com.senac.model.Oferta;
import br.com.senac.model.Enums.CursoStatus;

public class CursoResponse {
	
	private Integer id;
	private String nome;
	private String codigo;
	private CursoTipo cursoTipoId;
	private Integer horas;
	private CursoStatus status;
	private List<Oferta> ofertas;
	
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
	public CursoTipo getCursoTipoId() {
		return cursoTipoId;
	}
	public void setCursoTipoId(CursoTipo cursoTipoId) {
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
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
}
