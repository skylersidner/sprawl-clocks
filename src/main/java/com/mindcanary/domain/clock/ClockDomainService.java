package com.mindcanary.domain.clock;

import java.util.List;

public interface ClockDomainService {
	
	public Clock getById(long clockId);
	
	public List<Clock> getAll();
	
	public Clock create(Clock newClock);
	
	public void update(Clock clock);
	
	public void delete(long clockId);

}
