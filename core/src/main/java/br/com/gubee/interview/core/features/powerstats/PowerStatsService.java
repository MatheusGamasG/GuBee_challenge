package br.com.gubee.interview.core.features.powerstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gubee.interview.core.model.PowerStats;

@Service
public class PowerStatsService {
	
	@Autowired
	private PowerStatsRepository psRep;
	
	public PowerStats createPowerStats(PowerStats powerStats) {
		return psRep.save(powerStats);
	}
	
	public PowerStats updatePowerStats(PowerStats powerStats) {
		psRep.updatePowerStats(powerStats);
		
		return powerStats;
	}
}
