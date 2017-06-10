package com.mindcanary.domain.clock;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.mindcanary.infrastructure.clock.ClockDaoService;

@Named
public class ClockDomainServiceImpl implements ClockDomainService {
	
	@Inject
	ClockDaoService clockDaoService;

	@Override
	public Clock getById(long clockId) {
		Clock clock = clockDaoService.getById(clockId);
		return clock;
	}

	@Override
	public List<Clock> getAll() {
		List<Clock> clocks = clockDaoService.getAll();
		return clocks;
	}

	@Override
	public Clock create(Clock newClock) {
		Clock clock = clockDaoService.create(newClock);
		return clock;
	}

	@Override
	public void update(Clock clock) {
		clockDaoService.update(clock);
	}

	@Override
	public void delete(long clockId) {
		// TODO Auto-generated method stub

	}

}
