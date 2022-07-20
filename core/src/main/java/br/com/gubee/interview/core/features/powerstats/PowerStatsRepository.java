package br.com.gubee.interview.core.features.powerstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.gubee.interview.core.model.PowerStats;

@Repository
public class PowerStatsRepository {

	private JdbcTemplate jdbcTemplate;

    @Autowired
    public PowerStatsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;;
    }
	  
	public PowerStats save(PowerStats powerStats) {
		String sqlQuery = "INSERT INTO interview_service.power_stats(id, strength, agility, dexterity, intelligence) "
				+ "VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlQuery,
				powerStats.getId(),
				powerStats.getStrength(),
				powerStats.getAgility(),
				powerStats.getDexterity(),
				powerStats.getIntelligence());
		return powerStats;
	}
	
	public PowerStats updatePowerStats(PowerStats powerStats) {
		String sqlQuery = "UPDATE interview_service.power_stats SET "
				+ "strength = ?, agility = ?, dexterity = ?, intelligence = ? "
				+ "WHERE id = ?";
		
		jdbcTemplate.update(sqlQuery, powerStats.getStrength(), powerStats.getAgility(), powerStats.getDexterity(), powerStats.getIntelligence(), powerStats.getId());
		
		return powerStats;
	}
}
