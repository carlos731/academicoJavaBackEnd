package br.com.senac.model.dtos;

import java.util.List;

import br.com.senac.model.Badge;

public class BadgeNivelDTO {
	
	private Integer id;	
	private String descricao;
	private List<Badge> badges;

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

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}
	
	

}
