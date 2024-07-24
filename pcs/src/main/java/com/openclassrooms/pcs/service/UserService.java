package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.User;
import com.openclassrooms.pcs.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService
{
	UserRepository userRepository;

	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<User> getUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id)
	{
		return userRepository.findById(id);
	}

	@Override
	public User getUserByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}

	@Override
	public void createUser(User user)
	{
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user)
	{
		userRepository.save(user);
	}

	@Override
	public void deleteUser(User user)
	{
		userRepository.delete(user);
	}
}
