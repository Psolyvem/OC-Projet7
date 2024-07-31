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

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{

		return http.authorizeHttpRequests(auth ->
		{
//			auth.requestMatchers("/admin").hasRole("ADMIN");
//			auth.requestMatchers("/user").hasRole("USER");
			//auth.requestMatchers("/*").permitAll();
			//auth.requestMatchers("/*").authenticated();
			auth.anyRequest().authenticated();
		})
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
				//.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
				.formLogin(Customizer.withDefaults())
				//.httpBasic(Customizer.withDefaults())
				.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception
	{
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
