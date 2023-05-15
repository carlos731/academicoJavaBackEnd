package br.com.senac.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senac.model.Enums.ObjetoAprendizagemStatus;

@Entity
@Table(name = "objeto_aprendizagem")
public class ObjetoAprendizagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "objeto_aprendizagem_id")
	private Integer id;
	@Column(name = "objeto_aprendizagem_descricao")
	private String descricao;
	@JsonIgnore
	@Lob
	@Column(name = "objeto_aprendizagem_blob" /*, columnDefinition = "LONGBLOB"*/)
	private byte[] blob;
	@Column(name = "objeto_aprendizagem_status")
	private ObjetoAprendizagemStatus status;
	@OneToOne
	@JoinColumn(name = "grau_dificuldade_id", referencedColumnName = "grau_dificuldade_id")
	private GrauDificuldade grauDificuldadeId;
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private Usuario usuarioId;
	@ManyToMany
	@JoinTable(
		name = "situacao_objeto_aprendizagem",
		joinColumns = { @JoinColumn(name = "objeto_aprendizagem_id", referencedColumnName = "objeto_aprendizagem_id")},
		inverseJoinColumns = { @JoinColumn(name = "situacao_aprendizagem_id", referencedColumnName = "situacao_aprendizagem_id")} 
	)
	private List<SituacaoAprendizagem> aprendizagens;
	
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
	public byte[] getBlob() {
		return blob;
	}
	public void setBlob(byte[] blob) {
		this.blob = blob;
	}
	public ObjetoAprendizagemStatus getStatus() {
		return status;
	}
	public void setStatus(ObjetoAprendizagemStatus status) {
		this.status = status;
	}
	public GrauDificuldade getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(GrauDificuldade grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<SituacaoAprendizagem> getAprendizagens() {
		return aprendizagens;
	}
	public void setAprendizagens(List<SituacaoAprendizagem> aprendizagens) {
		this.aprendizagens = aprendizagens;
	}
	
}
