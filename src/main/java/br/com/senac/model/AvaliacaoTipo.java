package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.senac.model.Enums.AvaliacaoTipoStatus;

@Entity
@Table(name = "avaliacao_tipo")
public class AvaliacaoTipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "avaliacao_tipo_id")
	private Integer id;
	@Column(name = "avaliacao_tipo_descricao")
	private String descricao;
	@Column(name = "avaliacao_tipo_status")
	private AvaliacaoTipoStatus status;
	
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
	public AvaliacaoTipoStatus getStatus() {
		return status;
	}
	public void setStatus(AvaliacaoTipoStatus status) {
		this.status = status;
	}
	
}
