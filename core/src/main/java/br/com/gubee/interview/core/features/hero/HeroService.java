package br.com.gubee.interview.core.features.hero;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gubee.interview.core.features.powerstats.PowerStatsService;
import br.com.gubee.interview.core.model.CompareDTO;
import br.com.gubee.interview.core.model.Hero;

@Service
public class HeroService {
	
	@Autowired
	private HeroRepository heroRep;
	
	@Autowired
	private PowerStatsService psService;
	
	public Hero createHero(Hero hero) {
		hero.getPowerStatsId().setId(UUID.randomUUID());
		hero.setId(UUID.randomUUID());
		psService.createPowerStats(hero.getPowerStatsId());
		return heroRep.save(hero);
	}
	
	public Hero getHeroById(String id) {		
		try {
			Hero hero = heroRep.findOne(id);
			return hero;
		} catch (RuntimeException e) {
			return null;
		}		
	}
	
	public Hero getHeroByName(String name) {
		try {
			Hero hero = heroRep.findOneByName(name);
			return hero;
		} catch (RuntimeException e) {
			return null;
		}
	}
	
	public CompareDTO compareHeros(CompareDTO compare) {
		Hero hero1 = heroRep.findOne(compare.getHero1_ID());
		Hero hero2 = heroRep.findOne(compare.getHero2_ID());
		
		compare.setStrengthDiff(hero1.getPowerStatsId().getStrength() - hero2.getPowerStatsId().getStrength());
		compare.setAgilityDiff(hero1.getPowerStatsId().getAgility() - hero2.getPowerStatsId().getAgility());
		compare.setDexterityDiff(hero1.getPowerStatsId().getDexterity() - hero2.getPowerStatsId().getDexterity());
		compare.setIntelligenceDiff(hero1.getPowerStatsId().getIntelligence() - hero2.getPowerStatsId().getIntelligence());
		return compare;
	}
	
	public Hero updateHero(String id, Hero hero) {
		Hero hero2 = heroRep.findOne(id);
	
		hero2.setId(UUID.fromString(id));
		hero2.setName(hero.getName());
		hero2.setRace(hero.getRace());
		hero2.setEnabled(hero.isEnabled());
		hero2.getPowerStatsId().setStrength(hero.getPowerStatsId().getStrength());
		hero2.getPowerStatsId().setDexterity(hero.getPowerStatsId().getDexterity());
		hero2.getPowerStatsId().setAgility(hero.getPowerStatsId().getAgility());
		hero2.getPowerStatsId().setIntelligence(hero.getPowerStatsId().getIntelligence());
		psService.updatePowerStats(hero2.getPowerStatsId());
		heroRep.updateHero(hero2);
		
		return hero2;
	}
	
	public boolean deleteHeroById(String id) {
		return heroRep.deleteById(id);
	}
}
