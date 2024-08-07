package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.User;
import com.openclassrooms.pcs.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the IUserService that gets and process information from the repositories.
 */
@Service
public class UserService implements IUserService
{
	UserRepository userRepository;

	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	/**
	 * Gets all the User from the database.
	 * @return an Iterable of User
	 */
	@Override
	public Iterable<User> getUsers()
	{
		return userRepository.findAll();
	}

	/**
	 * Gets a User from the database based on its ID.
	 * @return an Optional of User
	 */
	@Override
	public Optional<User> getUserById(int id)
	{
		return userRepository.findById(id);
	}

	/**
	 * Gets a User from the database based on its username.
	 * @return the User that matches the username, or null.
	 */
	@Override
	public User getUserByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}

	/**
	 * Save a User object to the database.
	 * @param user the User to save.
	 */
	@Override
	public void createUser(User user)
	{
		userRepository.save(user);
	}

	/**
	 * Updates a User object in the database or create it if it doesn't exist.
	 * @param user the User to update.
	 */
	@Override
	public void updateUser(User user)
	{
		userRepository.save(user);
	}

	/**
	 * Delete a User object if it exists in the database.
	 * @param user the User to delete.
	 */
	@Override
	public void deleteUser(User user)
	{
		userRepository.delete(user);
	}
}
