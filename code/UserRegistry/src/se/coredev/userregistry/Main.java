package se.coredev.userregistry;

import se.coredev.userregistry.model.User;
import se.coredev.userregistry.repository.ConsoleLogger;
import se.coredev.userregistry.repository.LogWrapperUserRepository;
import se.coredev.userregistry.repository.Logger;
import se.coredev.userregistry.repository.RepositoryListener;
import se.coredev.userregistry.repository.UserRepository;
import se.coredev.userregistry.repository.mysql.MySQLUserRepository;
import se.coredev.userregistry.service.UserService;

public final class Main {

	public static void main(String[] args) {

		// --> LogWrapperUserRepository (log) --> CachedUserRepository --> MySQLUserRepository
		
		Logger logger = new ConsoleLogger();
		UserRepository mySQLUserRepository =  new MySQLUserRepository()
													.addListener(u -> System.err.println(u))
													.addListener(u -> System.err.println(u));
		
		UserRepository userRepository = new LogWrapperUserRepository(logger, mySQLUserRepository);
		UserService userService = new UserService(userRepository);
		userService.addUser(new User("Master"));
//		User user = userService.getUserById("1001");
//		System.out.println(user);
		
	}

}
