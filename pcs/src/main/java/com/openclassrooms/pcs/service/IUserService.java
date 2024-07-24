package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.User;

import java.util.Optional;

public interface IUserService
{
	public Iterable<User> getUsers();

	public Optional<User> getUserById(int id);

	public User getUserByUsername(String name);

	public void createUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
}
