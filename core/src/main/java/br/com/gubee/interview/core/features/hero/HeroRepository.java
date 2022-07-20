package br.com.gubee.interview.core.features.hero;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.gubee.interview.core.model.Hero;
import br.com.gubee.interview.core.model.PowerStats;

@Repository
public class HeroRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	  @Autowired
	  public HeroRepository(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }
	  
	  public Hero save(Hero hero) {
		  String sqlQuery = "INSERT INTO interview_service.hero(name, race, power_stats_id, enabled) " +
		                    "VALUES (?, ?, ?, ?)";
		  jdbcTemplate.update(sqlQuery,
				  			  hero.getName(),
				  			  hero.getRace(),
				  			  hero.getPowerStatsId().getId(),
				  			  hero.isEnabled());
		  return hero;
	}
	  
	public Hero findOne(UUID id) {
		String sqlQuery = "SELECT name, race, enabled, strength, agility, dexterity, intelligence "
				+ "FROM interview_service.hero "
				+ "INNER JOIN interview_service.power_stats "
				+ "ON interview_service.hero.power_stats_id=interview_service.power_stats.id "
				+ "WHERE interview_service.hero.id = ?";
		
		return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToHero, id);
	}
	
	public Hero findOneByName(String name) {
		String sqlQuery = "SELECT name, race, enabled, strength, agility, dexterity, intelligence "
				+ "FROM interview_service.hero "
				+ "INNER JOIN interview_service.power_stats "
				+ "ON interview_service.hero.power_stats_id=interview_service.power_stats.id "
				+ "WHERE interview_service.hero.name = ?";
		
		return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToHero, name);
	}
	
	private Hero mapRowToHero(ResultSet resultSet, int rowNum) throws SQLException {
		
	    PowerStats ps = new PowerStats(resultSet.getInt("strength"), resultSet.getInt("agility"), resultSet.getInt("dexterity"), resultSet.getInt("intelligence"));
		Hero hero = new Hero(resultSet.getString("name"), resultSet.getString("race"), ps, resultSet.getBoolean("enabled"));
		
		return hero;
	}
}
