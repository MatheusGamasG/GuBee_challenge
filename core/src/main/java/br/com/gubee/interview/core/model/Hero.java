package br.com.gubee.interview.core.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Hero {
	@Id
	private UUID id;
	private String name;
	private String race;
	@Column("power_stats_id")
	private PowerStats powerStatsId;
	private boolean enabled;
	private Date created_at;
	private Date updated_at;
	
	public Hero(String name, String race, PowerStats powerStatsId, boolean enabled) {
		this.name = name;
		this.race = race;
		this.powerStatsId = powerStatsId;
		this.enabled = enabled;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public PowerStats getPowerStatsId() {
		return powerStatsId;
	}
	public void setPowerStatsId(PowerStats power_stats_id) {
		this.powerStatsId = power_stats_id;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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