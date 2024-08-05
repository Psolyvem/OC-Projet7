package com.openclassrooms.pcs.controllers;

import com.openclassrooms.pcs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling HTTP request for login.
 */
@Controller
@RequestMapping("app")
public class LoginController
{

	@Autowired
	private UserRepository userRepository;

//	@GetMapping("login")
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login");
//		return mav;
//	}

}
