package com.jobdispatcher.exception;

public class JobDispatcherAdapterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobDispatcherAdapterException() {
		super();
	}
	
	public JobDispatcherAdapterException(String message) {
		super(message);
	}

	public JobDispatcherAdapterException(Throwable throwable) {
		super(throwable);
	}
	
	public JobDispatcherAdapterException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
