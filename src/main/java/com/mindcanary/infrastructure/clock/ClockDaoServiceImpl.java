package com.mindcanary.infrastructure.clock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mindcanary.domain.clock.Clock;
import com.mindcanary.exceptions.ClockNotFoundException;
import com.mindcanary.infrastructure.rowMapper.ClockRowMapper;

@Named
public class ClockDaoServiceImpl implements ClockDaoService {
	
	@Inject
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Clock getById(long clockId) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("clockId", clockId);
		
		String sql = "SELECT * \n"
				+ "FROM clocks \n"
				+ "WHERE clocks.clock_id = :clockId";
		
		try {
			Clock clock = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new ClockRowMapper());
			return clock;
		} catch (Exception e) {
			String message = "Clock with Id: " + clockId + " could not be found";
			throw new ClockNotFoundException(message);
		}
	}

	@Override
	public List<Clock> getAll() {
		// this method will need modification when I add users and associations
		String sql = "SELECT * FROM clocks";
		
		List<Clock> clocks = namedParameterJdbcTemplate.query(sql, new ClockRowMapper());
		return clocks;
	}

	@Override
	public Clock create(Clock newClock) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		paramMap.addValue("name", newClock.getName());
		paramMap.addValue("description", newClock.getDescription());
		paramMap.addValue("realmId", newClock.getRealm().getId());
		paramMap.addValue("countdownId", newClock.getCountdown().getId());
		
		String sql = "INSERT INTO clocks ( \n"
				+ "name \n"
				+ "description \n"
				+ "realm_id \n"
				+ "countdown_id \n"
				+ ") VALUES ( \n"
				+ ":name \n"
				+ ":description \n"
				+ ":realmId \n"
				+ ":countdownId \n"
				+ ")";
		
		KeyHolder holder = new GeneratedKeyHolder();
		
		long clockId = namedParameterJdbcTemplate.update(sql, paramMap, holder);
		newClock.setId(clockId);
		
		return newClock;
	}

	@Override
	public void update(Clock clock) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		paramMap.addValue("clockId", clock.getId());
		paramMap.addValue("name", clock.getName());
		paramMap.addValue("description", clock.getDescription());
		paramMap.addValue("realmId", clock.getRealm().getId());
		paramMap.addValue("countdownId", clock.getCountdown().getId());
		
		String sql = "UPDATE clocks \n"
				+ "SET \n"
				+ "name = :name, \n"
				+ "description = :description, \n"
				+ "realm_id = :realmId \n"
				+ "countdown_id = :countdownId \n"
				+ "WHERE clocks.clock_id = :clockId";
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public void delete(long clockId) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		paramMap.addValue("clockId", clockId);
		
		String sql = "DELETE FROM clocks \n"
				+ "WHERE clocks.clock_id = :clockId";
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

}
