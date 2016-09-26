package se.coredev.junit.model;

public final class User {

	private final String id;
	private final String username;

	public User(String id, String username) {
		
		if (!id.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid id. Only numbers allowed");
		}
		if(username.length() < 6){
			throw new IllegalArgumentException("Username is too short. Must be at least 6 characters long");
		}
		this.id = id;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * id.hashCode();
		result += 37 * username.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other instanceof User) {
			User otherUser = (User) other;
			return id.equals(otherUser.id) && username.equals(otherUser.username);
		}

		return false;
	}

}
