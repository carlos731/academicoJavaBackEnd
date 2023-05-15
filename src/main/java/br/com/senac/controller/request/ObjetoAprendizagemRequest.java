package br.com.senac.controller.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.senac.model.SituacaoAprendizagem;
import br.com.senac.model.Enums.ObjetoAprendizagemStatus;

public class ObjetoAprendizagemRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO")
	private String descricao;
	private byte[] blob;
	@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO")
	private ObjetoAprendizagemStatus status;
	@NotNull(message = "O CAMPO GRAU DE DIFICULDADE DEVE SER PREENCHIDO")
	private Integer grauDificuldadeId;
	@NotNull(message = "O CAMPO USUARIO DEVE SER PREENCHIDO")
	private Integer usuarioId;
	@NotNull(message = "O campo aprendizagens deve ser preenchido!!")
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
	public Integer getGrauDificuldadeId() {
		return grauDificuldadeId;
	}
	public void setGrauDificuldadeId(Integer grauDificuldadeId) {
		this.grauDificuldadeId = grauDificuldadeId;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<SituacaoAprendizagem> getAprendizagens() {
		return aprendizagens;
	}
	public void setAprendizagens(List<SituacaoAprendizagem> aprendizagens) {
		this.aprendizagens = aprendizagens;
	}
	

}
