package se.coredev.userregistry.repository;

public final class RepositoryException extends Exception {

	private static final long serialVersionUID = -416691327491428008L;

	public RepositoryException(String message){
		super(message);
	}
	
	public RepositoryException(String message, Throwable throwable){
		super(message, throwable);
	}
	
}
