package com.example.job.advertisements.web.app.exceptionHandler;

public class JobNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public JobNotFoundException() {
		super();
	}

	public JobNotFoundException(String message) {
		super(message);
	}
}
