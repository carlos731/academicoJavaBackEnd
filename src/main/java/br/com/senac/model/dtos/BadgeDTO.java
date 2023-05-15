package br.com.senac.model.dtos;

import br.com.senac.model.BadgeNivel;
import br.com.senac.model.Enums.BadgeStatus;

public class BadgeDTO {

	private Integer id;
	private String descricao;
	private byte[] img;
	private BadgeStatus status;
	private BadgeNivel badgeNivelId;

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

	public BadgeNivel getBadgeNivelId() {
		return badgeNivelId;
	}

	public void setBadgeNivelId(BadgeNivel badgeNivelId) {
		this.badgeNivelId = badgeNivelId;
	}


}
