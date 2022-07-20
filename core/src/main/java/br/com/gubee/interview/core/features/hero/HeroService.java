package br.com.gubee.interview.core.features.hero;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gubee.interview.core.features.powerstats.PowerStatsRepository;
import br.com.gubee.interview.core.model.Hero;

@Service
public class HeroService {
	
	@Autowired
	private HeroRepository heroRep;
	
	@Autowired
	private PowerStatsRepository psRep;
	
	public Hero createHero(Hero hero) {
		hero.getPowerStatsId().setId(UUID.randomUUID());
		psRep.createPowerStats(hero.getPowerStatsId());
		return heroRep.save(hero);
	}
	
	public Hero getHeroById(UUID id) {		
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
}
