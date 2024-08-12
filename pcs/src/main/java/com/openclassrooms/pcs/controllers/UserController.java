package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.domain.User;
import com.openclassrooms.pcs.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinylog.Logger;

import java.security.Principal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller for handling HTTP request concerning Users.
 */
@Controller
public class UserController
{
	private IUserService userService;

	public UserController(IUserService userService)
	{
		this.userService = userService;
	}

	@RequestMapping("/user/list")
	public String home(Model model, Principal principal)
	{
		model.addAttribute("users", userService.getUsers());
		return "user/list";
	}

	@GetMapping("/user/add")
	public String addUser(User user)
	{
		return "user/add";
	}

	@Transactional
	@PostMapping("/user/validate")
	public String validate(@Valid User user, BindingResult result, Model model)
	{
		Pattern pattern = Pattern.compile("^(?=.*?[A-Z]+)(?=.*?[a-z]+)(?=.*?[0-9]+)(?=.*[\\.+\\-*$£%!§:\\/;,?&~\\\"#'_@=¤µ]+)(?!.*[\\s]+.*).{8,32}$");
		Matcher matcher = pattern.matcher(user.getPassword());
		boolean isPasswordCorrect = matcher.matches();

		if(userService.getUserByUsername(user.getUsername()) != null)
		{
			result.addError(new FieldError("username", "username", "Username already exists"));
		}
		if (!isPasswordCorrect && !result.hasFieldErrors("password"))
		{
			result.addError(new FieldError("password", "password", "Password must contain at least one uppercase letter, one lowercase, a digit and a special character and be between 8 and 32 char. long."));
		}
		if (!result.hasErrors())
		{

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			userService.createUser(user);
			model.addAttribute("users", userService.getUsers());
			return "redirect:/user/list";
		}
		return "user/add";
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			User user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			user.setPassword("");
			model.addAttribute("user", user);
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid user id : " + id + ", unable to update.");
			return "redirect:/user/list";
		}
		return "user/update";
	}

	@Transactional
	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model)
	{
		Pattern pattern = Pattern.compile("^(?=.*?[A-Z]+)(?=.*?[a-z]+)(?=.*?[0-9]+)(?=.*[\\.+\\-*$£%!§:\\/;,?&~\\\"#'_@=¤µ]+)(?!.*[\\s]+.*).{8,32}$");
		Matcher matcher = pattern.matcher(user.getPassword());
		boolean isPasswordCorrect = matcher.matches();

		if(userService.getUserByUsernameExcludeActual(user.getUsername(), user.getId()) != null)
		{
			result.addError(new FieldError("username", "username", "Username already exists"));
		}
		if (!isPasswordCorrect && !result.hasFieldErrors("password"))
		{
			result.addError(new FieldError("password", "password", "Password must contain at least one uppercase letter, one lowercase, a digit and a special character and be between 8 and 32 char. long."));
		}
		if (result.hasErrors())
		{
			return "user/update";
		}
		try
		{
			userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException());
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setId(id);
			userService.updateUser(user);
			model.addAttribute("users", userService.getUsers());
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid user id : " + id + ", unable to update.");
		}
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model)
	{
		try
		{
			User user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException());
			userService.deleteUser(user);
			model.addAttribute("users", userService.getUsers());
		}
		catch (IllegalArgumentException e)
		{
			Logger.error("Invalid user id : " + id + ", unable to delete.");
		}
		return "redirect:/user/list";
	}
}
