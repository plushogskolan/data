package se.coredev.junit.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public final class UserTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
//	@Test(expected = IllegalArgumentException.class)
	@Test
	public void shouldThrowExceptionIfIdContainsLetters() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid id. Only numbers allowed");
		
		new User("a1001", "master");
	}

	@Test
	public void shouldThrowExceptionIfUsernameIsTooShort() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Username is too short. Must be at least 6 characters long");
		
		new User("1001", "yoda");
	}

	@Test
	public void usersWithSameValuesShouldBeEqual() {

		final String id = "1001";
		final String username = "master";
		final User user1 = new User(id, username);
		final User user2 = new User(id, username);

		assertEquals(user1, user2);
	}

	@Test
	public void usersThatAreEqualShouldProduceSameHashCode() {

		final String id = "2002";
		final String username = "master";
		final User user1 = new User(id, username);
		final User user2 = new User(id, username);

		assertEquals(user1.hashCode(), user2.hashCode());
	}

}
