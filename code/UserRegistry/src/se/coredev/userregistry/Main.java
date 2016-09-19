package se.coredev.userregistry;

import se.coredev.userregistry.model.User;
import se.coredev.userregistry.repository.UserRepository;
import se.coredev.userregistry.repository.memory.InMemoryUserRepository;
import se.coredev.userregistry.repository.mysql.MySQLUserRepository;
import se.coredev.userregistry.service.UserService;

public final class Main {

	public static void main(String[] args) {

		UserRepository userRepository = new InMemoryUserRepository(); //new MySQLUserRepository();
		UserService userService = new UserService(userRepository);
		User user = userService.getUserById("1001");
		
		
	}

}
