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

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUserService userService;

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

	private List<GrantedAuthority> getGrantedAuthorities(String role)
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(role == "ADMIN")
		{
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}
}
