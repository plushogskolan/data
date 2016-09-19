package se.coredev.userregistry.repository.memory;

import java.util.HashMap;
import java.util.Map;

import se.coredev.userregistry.model.User;
import se.coredev.userregistry.repository.RepositoryException;
import se.coredev.userregistry.repository.UserRepository;

public final class InMemoryUserRepository implements UserRepository {

	private final Map<String, User> users;

	public InMemoryUserRepository() {
		users = new HashMap<>();
	}

	@Override
	public User get(String id) throws RepositoryException {
		return users.get(id);
	}

	@Override
	public void add(User user) throws RepositoryException {
		users.put(user.getId(), user);
	}

	@Override
	public boolean exists(User user) throws RepositoryException {
		for (User u : users.values()) {
			if (u.getUsername().equals(user.getUsername())) {
				return true;
			}
		}
		return false;
	}

}
