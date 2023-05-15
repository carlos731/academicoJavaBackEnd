package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "oferta")
public class Oferta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oferta_id")
	private Integer id;
	@Column(name = "oferta_descricao")
	private String descricao;
	@Column(name = "oferta_codigo")
	private String codigo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "oferta_inico_operacao")
	private LocalDate inicioOperacao = LocalDate.now();
	@Column(name = "oferta_status")
	private Integer status;
	@ManyToOne//Colocar ManyToOne!!!
	@JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
	private Curso cursoId;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getInicioOperacao() {
		return inicioOperacao;
	}
	public void setInicioOperacao(LocalDate inicioOperacao) {
		this.inicioOperacao = inicioOperacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Curso getCursoId() {
		return cursoId;
	}
	public void setCursoId(Curso cursoId) {
		this.cursoId = cursoId;
	}
		
}
