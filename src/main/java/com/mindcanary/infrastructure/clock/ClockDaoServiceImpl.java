package com.mindcanary.infrastructure.clock;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mindcanary.domain.clock.Clock;
import com.mindcanary.infrastructure.rowMapper.ClockRowMapper;

@Named
public class ClockDaoServiceImpl implements ClockDaoService {
	
	@Inject
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Clock getById(long id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Clock clock) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long clockId) {
		// TODO Auto-generated method stub

	}

}
