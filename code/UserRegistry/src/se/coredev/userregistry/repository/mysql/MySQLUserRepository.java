package se.coredev.userregistry.repository.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.coredev.userregistry.model.User;
import se.coredev.userregistry.repository.RepositoryException;
import se.coredev.userregistry.repository.RepositoryListener;
import se.coredev.userregistry.repository.UserRepository;

public final class MySQLUserRepository implements UserRepository {

	private static final String URL = "Add connection URL here";
	private final List<RepositoryListener> listeners;

	public MySQLUserRepository() {
		listeners = new ArrayList<>();
	}

	@Override
	public UserRepository addListener(RepositoryListener listener) {
		listeners.add(listener);
		return this;
	}

	@Override
	public User get(String id) throws RepositoryException {

		try (Connection connection = DriverManager.getConnection(URL)) {
			// talk to the database here
			return null;
		}
		catch (SQLException e) {
			throw new RepositoryException("Error fetching user with id:" + id, e);
		}
	}

	@Override
	public void add(User user) throws RepositoryException {

//		try (Connection connection = DriverManager.getConnection(URL)) {
			// insert user into database here
			notifyAdd(user);
//		}
//		catch (SQLException e) {
//			throw new RepositoryException("Could not persist user with id:" + user.getId(), e);
//		}
	}

	private void notifyAdd(User user) {
		for (RepositoryListener listener : listeners) {
			listener.userAdded(user);
		}
	}

	@Override
	public boolean exists(User user) throws RepositoryException {

		return false;
	}

}












