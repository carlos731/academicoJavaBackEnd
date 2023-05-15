package br.com.senac.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senac.model.Enums.CursoStatus;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private Integer id;
	@Column(name = "curso_nome")
	private String nome;
	@Column(name = "curso_codigo", unique = true)
	private String codigo;
	@OneToOne
	@JoinColumn(name = "curso_tipo_id", referencedColumnName = "curso_tipo_id")
	private CursoTipo cursoTipoId;
	@Column(name = "curso_horas")
	private Integer horas;
	@Column(name = "curso_status")
	private CursoStatus status;
	@JsonIgnore
	@OneToMany(mappedBy = "cursoId")
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
