package se.coredev.userregistry.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -3447542605446134598L;

	public ServiceException(String message){
		super(message);
	}

	public ServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
