package com.openclassrooms.pcs.security;

import com.openclassrooms.pcs.domain.User;
import com.openclassrooms.pcs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements UserDetailsService from Spring to manage custom users from our database.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUserService userService;

	/**
	 * Implementation of the loadByUsername method that uses the database users to retrieve needed information for the authentication system.
	 * @param username A String that matches an username present in the DB.
	 * @return	An UserDetails object with the information fetched from a DB user.
	 * @throws UsernameNotFoundException if the username provided does not match any DB user.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userService.getUserByUsername(username);
		if (user == null)
		{
			throw new UsernameNotFoundException("Username not found");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRole()));

	}

	/**
	 * Convert the role of a user from "ADMIN" or "USER" to a Spring-readable list.
	 * @param role the role of the user, as registered in the DB, can be either "ADMIN" or "USER".
	 * @return A list of GrantedAuthority with the role(s) of a user.
	 */
	private List<GrantedAuthority> getGrantedAuthorities(String role)
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(role.equals("ADMIN"))
		{
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}
}
