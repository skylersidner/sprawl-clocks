package com.mindcanary.infrastructure.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindcanary.domain.clock.Clock;
import com.mindcanary.domain.type.RealmType;
import com.mindcanary.domain.type.CountdownType;

public class ClockRowMapper implements RowMapper<Clock> {
	
	@Override
	public Clock mapRow(ResultSet rs, int arg1) throws SQLException {
		Clock clock = new Clock();
		
		CountdownType countdown = CountdownType.fromId(rs.getLong("countdown_id"));
		clock.setCountdown(countdown);
		
		RealmType realm = RealmType.fromId(rs.getLong("realm_id"));
		clock.setRealm(realm);
		
		clock.setName(rs.getString("name"));
		clock.setDescription(rs.getString("description"));
		
		return clock;
	}
	
	
	
	

}
