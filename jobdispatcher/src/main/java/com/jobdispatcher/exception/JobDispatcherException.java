package com.jobdispatcher.exception;

public class JobDispatcherException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobDispatcherException() {
		super();
	}
	
	public JobDispatcherException(String message) {
		super(message);
	}

	public JobDispatcherException(Throwable throwable) {
		super(throwable);
	}
	
	public JobDispatcherException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
