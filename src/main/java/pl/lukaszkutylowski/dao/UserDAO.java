package pl.lukaszkutylowski.dao;

import java.util.List;

import pl.lukaszkutylowski.model.User;

public interface UserDAO extends GenericDAO<User, Long> {

	List<User> getAll();
	User getUserByUsername(String username);
}
