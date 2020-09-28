package com.educaciencia.demo.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	private static final String[] AUTH_WHITELIST = { "/v1/api-docs-educa", "/swagger-resources/**", "/configuration/ui",
			"/configuration/security", "/swagger-ui.html**", "/webjars/**", "/actuator/**", "/version/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
				// .anyRequest().authenticated()
				.and().httpBasic().authenticationEntryPoint(authEntryPoint);
	}

}

