package se.coredev.userregistry.service;

import se.coredev.userregistry.model.User;
import se.coredev.userregistry.repository.RepositoryException;
import se.coredev.userregistry.repository.UserRepository;

public final class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserById(String id) {
		try {
			return userRepository.get(id);
		}
		catch (RepositoryException e) {
			throw new ServiceException("Could not get user with id: " + id, e);
		}
	}

	public UserService addUser(User user) {

		try {
			if (userRepository.exists(user)) {
				throw new ServiceException("User with username: " + user.getUsername() + " already exist in storage");
			}

			userRepository.add(user);
			return this;
		}
		catch (RepositoryException e) {
			throw new ServiceException("Could not add user with id: " + user.getId(), e);
		}
	}

}
