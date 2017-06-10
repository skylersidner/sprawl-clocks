package com.mindcanary.exceptions;

public class ClockNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ClockNotFoundException() {
		super("Failed to find Clock");
	}
	
	public ClockNotFoundException(String message) {
		super(message);
	}

}
