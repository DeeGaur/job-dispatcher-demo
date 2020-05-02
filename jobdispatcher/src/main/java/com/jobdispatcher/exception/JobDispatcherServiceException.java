package com.jobdispatcher.exception;

public class JobDispatcherServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobDispatcherServiceException() {
		super();
	}
	
	public JobDispatcherServiceException(String message) {
		super(message);
	}

	public JobDispatcherServiceException(Throwable throwable) {
		super(throwable);
	}
	
	public JobDispatcherServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
