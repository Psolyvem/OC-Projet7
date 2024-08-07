package com.openclassrooms.pcs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	/**
	 * Define the Security filter chain for the application.
	 * Make the endpoints only accessible after authentification except for css and errors.
	 * Also restrict the endpoint used for user management to admins.
	 * Define a session-based authentication with Spring Security
	 * @return the SecurityFilterChain used as a bean by Spring.
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		return http.authorizeHttpRequests(auth ->
		{
			auth.requestMatchers("/static/**").permitAll();
			auth.requestMatchers("/user/**").hasRole("ADMIN");
			auth.requestMatchers("/**").hasAnyRole("USER", "ADMIN");
			auth.anyRequest().authenticated();

		})
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
				.formLogin(Customizer.withDefaults())
				//.httpBasic(Customizer.withDefaults())
				.build();
	}

	/**
	 * Gives Spring Security an Authentication Manager that uses our custom users from database to authenticate them.
	 * @return the AuthenticationManager used as a bean by Spring.
	 */
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception
	{
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}

	/**
	 * Provides a encoder for the Spring context to use.
	 * @return the BCryptPasswordEncoder used as a bean by Spring.
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
