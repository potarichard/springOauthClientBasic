package com.web;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		
		http 
			.antMatcher("/**").authorizeRequests()
			.antMatchers("/users/**").permitAll()
			.anyRequest().authenticated()			
			.and().oauth2Login()
			.and().cors()								// allow cross origin requests...
			.and().csrf().disable();					// patch, post, delete requests need it
	}
}
