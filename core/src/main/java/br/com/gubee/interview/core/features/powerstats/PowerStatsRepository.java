package br.com.gubee.interview.core.features.powerstats;

import java.util.UUID;

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
	  
	public UUID createPowerStats(PowerStats powerStats) {
		String sqlQuery = "INSERT INTO interview_service.power_stats(id, strength, agility, dexterity, intelligence) "
				+ "VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlQuery,
				powerStats.getId(),
				powerStats.getStrength(),
				powerStats.getAgility(),
				powerStats.getDexterity(),
				powerStats.getIntelligence());
		return powerStats.getId();
	}
}
