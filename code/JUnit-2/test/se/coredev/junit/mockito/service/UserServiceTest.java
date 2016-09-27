package se.coredev.junit.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import se.coredev.junit.mockito.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	@Mock
	private IdGenerator idGenerator;
	@InjectMocks
	private UserService service;

	@Test
	public void canAuthenticate() {
		String username = "master";
		String password = "secret";
		
		when(userRepository.login(username, password)).thenThrow(new RuntimeException());
		service.authenticate(username, password);
		
		verify(userRepository, times(3)).login(username, password);
	}

	@Test
	public void canCreateUser() {

		Long number = 1001L;
		when(idGenerator.generate()).thenReturn(number);

		String username = "master";
		String password = "secret";

		User user = service.createUser(username, password);
		assertNotNull(user.getNumber());
		assertEquals(number, user.getNumber());
		assertEquals(username, user.getUsername());
		assertEquals(password, user.getPassword());

		verify(userRepository).save(user);
	}

}
