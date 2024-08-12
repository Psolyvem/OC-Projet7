package com.openclassrooms.pcs.controller;

import com.openclassrooms.pcs.controllers.UserController;
import com.openclassrooms.pcs.domain.User;
import com.openclassrooms.pcs.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.security.Principal;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest
{
	UserController userController;
	@Mock
	IUserService userService;
	@Mock
	Model model;
	@Mock
	BindingResult bindingResult;
	@Mock
	Principal principal;
	User user;

	@BeforeEach
	public void setUp()
	{
		this.userController = new UserController(this.userService);

		this.user = new User();
		user.setUsername("Test");
		user.setPassword("Test");
		user.setFullname("Test");
		user.setRole("USER");
	}

	@Test
	public void homeTest()
	{
		userController.home(model, principal);
		verify(userService, times(1)).getUsers();
	}

	@Test
	public void validateTest()
	{
		userController.validate(user, bindingResult, model);
		verify(userService, times(1)).createUser(user);
	}

	@Test
	public void showUpdateFormTest()
	{
		when(userService.getUserById(1)).thenReturn(Optional.of(user));
		userController.showUpdateForm(1, model);
		verify(userService, times(1)).getUserById(1);
	}

	@Test
	public void updateUserTest()
	{
		when(userService.getUserById(1)).thenReturn(Optional.of(user));
		userController.updateUser(1, user, bindingResult, model);
		verify(userService, times(1)).updateUser(user);
	}

	@Test
	public void deleteUserTest()
	{
		when(userService.getUserById(1)).thenReturn(Optional.of(user));
		userController.deleteUser(1, model);
		verify(userService, times(1)).deleteUser(user);
	}
}
