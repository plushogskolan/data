package se.coredev.junit.mockito.model;

public final class User {

	private final Long number;
	private final String username;
	private final String password;

	public User(Long number, String username, String password) {
		this.number = number;
		this.username = username;
		this.password = password;
	}

	public Long getNumber() {
		return number	;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
