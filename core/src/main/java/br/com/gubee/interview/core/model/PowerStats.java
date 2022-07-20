package br.com.gubee.interview.core.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class PowerStats {
	@Id
	private UUID id;
	private Integer strength;
	private Integer agility;
	private Integer dexterity;
	private Integer intelligence;
	private Date created_at;
	private Date updated_at;
	
	public PowerStats(Integer strength, Integer agility, Integer dexterity, Integer intelligence) {
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
	}

	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public Integer getAgility() {
		return agility;
	}
	public void setAgility(Integer agility) {
		this.agility = agility;
	}
	public Integer getDexterity() {
		return dexterity;
	}
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}
	public Integer getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
}