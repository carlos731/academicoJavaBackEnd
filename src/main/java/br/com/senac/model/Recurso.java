package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senac.model.Enums.Status;

@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recurso_id")
	private Integer id;
	@Column(name = "recurso_descricao")
	private String descricao;
	@Column(name = "recurso_nome_arquivo")
	private String filename;
	@JsonIgnore
	@Lob
	@Column(name = "recurso_blob")
	private byte[] file;
	@Column(name = "recurso_status")
	private Status status;
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private Usuario usuarioId;
	
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
