package com.mindcanary.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindcanary.domain.clock.Clock;
import com.mindcanary.domain.clock.ClockDomainService;

@RestController
@RequestMapping("/clocks")
public class ClockController {
	
	@Inject
	ClockDomainService clockDomainService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Clock>> getAllClocks() {
		List<Clock> clocks = clockDomainService.getAll();
		
		return new ResponseEntity<List<Clock>>(clocks, HttpStatus.OK);
	}

	@RequestMapping(value = "/{clockId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Clock> getById(@PathVariable long clockId) {
		Clock clock = clockDomainService.getById(clockId);
		
		return new ResponseEntity<Clock>(clock, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Clock> create(@RequestBody Clock newClock) {
		Clock clock = clockDomainService.create(newClock);
		
		return new ResponseEntity<Clock>(clock, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{clockId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> update(@PathVariable long clockId, @RequestBody Clock clock) {
		clockDomainService.update(clock);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{clockId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON) 
	public ResponseEntity<String> delete(@PathVariable long clockId) {
		clockDomainService.delete(clockId);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

}
