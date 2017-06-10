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
	public Clock getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clock> getAll() {
		List<Clock> clocks = clockDaoService.getAll();
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
