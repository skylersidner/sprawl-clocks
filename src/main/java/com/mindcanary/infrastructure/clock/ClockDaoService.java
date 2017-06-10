package com.mindcanary.infrastructure.clock;

import java.util.List;

import com.mindcanary.domain.clock.Clock;

public interface ClockDaoService {
	
	public Clock getById(long id);
	
	public List<Clock> getAll();
	
	public Clock create(Clock newClock);
	
	public void update(Clock clock);
	
	public void delete(long clockId);

}
