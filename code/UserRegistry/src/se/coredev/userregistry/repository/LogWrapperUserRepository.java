package se.coredev.userregistry.repository;

import se.coredev.userregistry.model.User;

public final class LogWrapperUserRepository implements UserRepository {

	private final Logger logger;
	private final UserRepository userRepository;

	public LogWrapperUserRepository(Logger logger, UserRepository userRepository) {
		this.logger = logger;
		this.userRepository = userRepository;
	}

	@Override
	public UserRepository addListener(RepositoryListener listener) {
		return userRepository.addListener(listener);
	}
	
	
	@Override
	public User get(String id) throws RepositoryException {
		logger.info("get user with id:" + id);
		return userRepository.get(id);
	}

	@Override
	public void add(User user) throws RepositoryException {
		logger.info("Adding user with id: " + user.getId());
		userRepository.add(user);
	}

	@Override
	public boolean exists(User user) throws RepositoryException {
		logger.info("Check if user with id: " + user.getId() + " exists");
		return userRepository.exists(user);
	}


}
