package br.com.senac.controller.response;

import java.util.List;

import br.com.senac.model.GrauDificuldade;
import br.com.senac.model.SituacaoAprendizagem;
import br.com.senac.model.Usuario;
import br.com.senac.model.Enums.ObjetoAprendizagemStatus;

public class ObjetoAprendizagemResponse {
	
	private Integer id;
	private String descricao;
	private byte[] blob;
	private ObjetoAprendizagemStatus status;
	private GrauDificuldade grauDificuldadeId;
	private Usuario usuarioId;
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
