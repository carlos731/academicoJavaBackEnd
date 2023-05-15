package br.com.senac.controller.request;

import javax.validation.constraints.NotNull;

import br.com.senac.model.Enums.BadgeStatus;

public class BadgeRequest {
	
	private Integer id;
	@NotNull(message = "O CAMPO DESCRIÇÃO DEVE SER PREENCHIDO!!")
	private String descricao;
	@NotNull(message = "O CAMPO IMG NECESS DEVE SER PREENCHIDO!!")
	private byte[] img;
	//@NotNull(message = "O CAMPO STATUS DEVE SER PREENCHIDO!!")
	private BadgeStatus status;
	@NotNull(message = "O CAMPO BADGE_NIVEL_ID DEVE SER PREENCHIDO!!")
	private Integer badgeNivelId;
	
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
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public BadgeStatus getStatus() {
		return status;
	}
	public void setStatus(BadgeStatus status) {
		this.status = status;
	}
	public Integer getBadgeNivelId() {
		return badgeNivelId;
	}
	public void setBadgeNivelId(Integer badgeNivelId) {
		this.badgeNivelId = badgeNivelId;
	}
	
}
