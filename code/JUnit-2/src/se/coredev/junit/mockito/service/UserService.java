package se.coredev.junit.mockito.service;

import java.util.concurrent.atomic.AtomicInteger;

import se.coredev.junit.mockito.model.User;

public final class UserService {

	private final UserRepository userRepository;
	private final IdGenerator idGenerator;
	private static final int MAX_NUMBER_OF_RETRIES = 3;

	public UserService(UserRepository userRepository, IdGenerator idGenerator) {
		this.userRepository = userRepository;
		this.idGenerator = idGenerator;
	}

	public User createUser(String username, String password) {
		Long number = idGenerator.generate();
		User user = new User(number, username, password);
		userRepository.save(user);

		return user;
	}

	public boolean authenticate(String username, String password) {

		AtomicInteger times = new AtomicInteger(0);
		while (times.get() < MAX_NUMBER_OF_RETRIES) {

			try {
				boolean result = userRepository.login(username, password);
				return result;
			}
			catch (RuntimeException e) {
				// sleep 1 second and the retry
				times.incrementAndGet();
			}
		}
		return false;

	}

}




















