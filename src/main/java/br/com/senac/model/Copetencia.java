package br.com.senac.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "copetencia")
public class Copetencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "copetencia_id")
	private Integer id;
	@Column(name = "copetencia_descricao")
	private String descricao;
	@Column(name = "copetencia_ordem")
	private Integer ordem;
	@Column(name = "copetencia_status")
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "unidade_curricular_id", referencedColumnName = "unidade_curricular_id")
	private UnidadeCurricular unidadeCurricularId;
	@JsonIgnore
	@OneToMany(mappedBy = "copetenciaId")
	private List<CopetenciaIndicador> indicadores;
	
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
	public UnidadeCurricular getUnidadeCurricularId() {
		return unidadeCurricularId;
	}
	public void setUnidadeCurricularId(UnidadeCurricular unidadeCurricularId) {
		this.unidadeCurricularId = unidadeCurricularId;
	}
	public List<CopetenciaIndicador> getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(List<CopetenciaIndicador> indicadores) {
		this.indicadores = indicadores;
	}
	
	
}
