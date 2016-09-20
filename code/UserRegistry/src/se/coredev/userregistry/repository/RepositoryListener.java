package se.coredev.userregistry.repository;

import se.coredev.userregistry.model.User;

public interface RepositoryListener {

	void userAdded(User user);
}
