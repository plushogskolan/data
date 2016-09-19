package se.coredev.userregistry.model;

import java.util.UUID;

public final class User {

	private final String id;
	private final String username;

	public User(String username) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof User) {
			User otherUser = (User) other;
			return id.equals(otherUser.id) && username.equals(otherUser.username);
		}

		return false;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * id.hashCode();
		result += 37 * username.hashCode();

		return result;
	}
}
