package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_curricular")
public class UnidadeCurricular implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unidade_curricular_id")
	private Integer id;
	@Column(name = "unidade_curricular_codigo")
	private String codigo;
	@Column(name = "unidade_curricular_nome")
	private String nome;
	@Column(name = "unidade_curricular_nome_curto")
	private String nomeCurto;
	@Column(name = "unidade_curricular_horas")
	private Integer horas;
	@Column(name = "unidade_curricular_modulo")
	private Integer modulo;
	@Column(name = "unidade_curricular_ordem")
	private Integer ordem;
	@Column(name = "unidade_curricular_status")
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "modulo_id", referencedColumnName = "modulo_id")
	private Modulo moduloId;

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
	public Modulo getModuloId() {
		return moduloId;
	}
	public void setModuloId(Modulo moduloId) {
		this.moduloId = moduloId;
	}

}
