package se.coredev.junit.mockito.service;

import se.coredev.junit.mockito.model.User;

public interface UserRepository {

	void save(User user);

	boolean login(String username, String password);

}
