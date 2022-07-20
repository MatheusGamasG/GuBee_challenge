package br.com.gubee.interview.core.model;

public class CompareDTO {
	String hero1_ID;
	Integer strengthDiff;
	Integer agilityDiff;
	Integer dexterityDiff;
	Integer intelligenceDiff;
	String hero2_ID;
	
	public CompareDTO(String hero1_ID, String hero2_ID) {
		super();
		this.hero1_ID = hero1_ID;
		this.hero2_ID = hero2_ID;
	}

	public String getHero1_ID() {
		return hero1_ID;
	}

	public void setHero1_ID(String hero1_ID) {
		this.hero1_ID = hero1_ID;
	}

	public Integer getStrengthDiff() {
		return strengthDiff;
	}

	public void setStrengthDiff(Integer strengthDiff) {
		this.strengthDiff = strengthDiff;
	}

	public Integer getAgilityDiff() {
		return agilityDiff;
	}

	public void setAgilityDiff(Integer agilityDiff) {
		this.agilityDiff = agilityDiff;
	}

	public Integer getDexterityDiff() {
		return dexterityDiff;
	}

	public void setDexterityDiff(Integer dexterityDiff) {
		this.dexterityDiff = dexterityDiff;
	}

	public Integer getIntelligenceDiff() {
		return intelligenceDiff;
	}

	public void setIntelligenceDiff(Integer intelligenceDiff) {
		this.intelligenceDiff = intelligenceDiff;
	}

	public String getHero2_ID() {
		return hero2_ID;
	}

	public void setHero2_ID(String hero2_ID) {
		this.hero2_ID = hero2_ID;
	}	
}
