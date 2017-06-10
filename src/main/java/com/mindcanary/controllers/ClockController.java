package com.mindcanary.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		List<Clock>  clocks = clockDomainService.getAll();
		
		return new ResponseEntity<List<Clock>>(clocks, HttpStatus.OK);
	}

}
