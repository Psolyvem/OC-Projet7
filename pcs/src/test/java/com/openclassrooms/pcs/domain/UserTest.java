package com.openclassrooms.pcs.domain;

import jakarta.validation.constraints.NotBlank;
import org.junit.jupiter.api.Test;

public class UserTest
{
	User user;

	@Test
	void userTest()
	{
		this.user = new User();
		user.setId(1);
		user.setUsername("test");
		user.setPassword("test");
		user.setFullname("test");
		user.setRole("test");

		user.getId();
		user.getUsername();
		user.getPassword();
		user.getFullname();
		user.getRole();
	}
}
