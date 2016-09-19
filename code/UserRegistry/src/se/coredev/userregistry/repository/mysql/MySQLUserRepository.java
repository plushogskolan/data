package se.coredev.userregistry.repository.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import se.coredev.userregistry.model.User;
import se.coredev.userregistry.repository.RepositoryException;
import se.coredev.userregistry.repository.UserRepository;

public final class MySQLUserRepository implements UserRepository {

	@Override
	public User get(String id) throws RepositoryException {
		
		try (Connection connection = DriverManager.getConnection("some_url_string")){
			// talk to the database here
			return null;
		}
		catch (SQLException e) {
			throw new RepositoryException("Error fetching user with id:" + id, e);
		}
	}

	@Override
	public void add(User user) throws RepositoryException {
		
		
		
		try (Connection connection = DriverManager.getConnection("some_url_string")){
			// insert user into database here
		}
		catch (SQLException e) {
			throw new RepositoryException("Could not persist user with id:" + user.getId());
		}
	}

	@Override
	public boolean exists(User user) throws RepositoryException {

		return false;
	}

}
