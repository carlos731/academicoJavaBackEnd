package br.com.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.senac.model.Enums.BadgeStatus;

@Entity
@Table(name = "badge")
public class Badge implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "badge_id")
	private Integer id;

	@Column(name = "badge_descricao")
	private String descricao;
	
	@Lob
	@Column(name = "badge_img")
	private byte[] img;
	
	@Column(name = "badge_status")
	private BadgeStatus status;
	
	@OneToOne
	@JoinColumn(name = "badge_nivel_id", referencedColumnName = "badge_nivel_id")
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
