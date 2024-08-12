package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.User;
import com.openclassrooms.pcs.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest
{
	IUserService userService;
	@Mock
	UserRepository userRepository;
	User user;

	@BeforeEach
	public void setUp()
	{
		this.userService = new UserService(this.userRepository);

		this.user = new User();
		user.setUsername("Test");
		user.setPassword("Test");
		user.setFullname("Test");
		user.setRole("USER");
	}

	@Test
	public void getUsersTest()
	{
		userService.getUsers();
		verify(userRepository, times(1)).findAll();
	}

	@Test
	public void getUserByIdTest()
	{
		userService.getUserById(1);
		verify(userRepository, times(1)).findById(1);
	}

	@Test
	public void getUserByUsernameTest()
	{
		userService.getUserByUsername("Test");
		verify(userRepository, times(1)).findByUsername("Test");
	}

	@Test
	public void getUserByUsernameExcludeActualTest()
	{
		userService.getUserByUsernameExcludeActual("Test", 1);
		verify(userRepository, times(1)).findByUsernameExcludeActual("Test", 1);
	}

	@Test
	public void createUserTest()
	{
		userService.createUser(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void updateUserTest()
	{
		userService.updateUser(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void deleteUserTest()
	{
		userService.deleteUser(user);
		verify(userRepository, times(1)).delete(user);
	}
}
