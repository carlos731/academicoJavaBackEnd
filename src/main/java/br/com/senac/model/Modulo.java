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

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "modulo_id")
	private Integer id;	
	@Column(name = "modulo_descricao")
	private String descricao;
	@Column(name = "modulo_carga_horaria")
	private Integer cargaHoraria;
	@OneToOne
	@JoinColumn(name = "oferta_id", referencedColumnName = "oferta_id")
	private Oferta ofertaId;
	@JsonIgnore
	@OneToMany(mappedBy = "moduloId")
	private List<UnidadeCurricular> unidadeCurriculares;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Oferta getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Oferta ofertaId) {
		this.ofertaId = ofertaId;
	}
	public List<UnidadeCurricular> getUnidadeCurriculares() {
		return unidadeCurriculares;
	}
	public void setUnidadeCurriculares(List<UnidadeCurricular> unidadeCurriculares) {
		this.unidadeCurriculares = unidadeCurriculares;
	}

}
