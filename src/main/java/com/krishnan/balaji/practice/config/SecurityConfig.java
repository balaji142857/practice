package com.krishnan.balaji.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userService;	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		/*auth.inMemoryAuthentication()
		.withUser("balaji").password("balaji").roles("admin","dba","user");*/
		auth.userDetailsService(userService);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/login/**").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/test/**").permitAll()
		.antMatchers("/users/**").permitAll()
		.antMatchers("/dummy/**").hasAnyAuthority("USER")
		.antMatchers("/redbus/**").hasAnyAuthority("USER")
		.antMatchers("/secured/**").hasAnyAuthority("USER")
		.and()
		.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.loginProcessingUrl("/authenticate")
			.failureUrl("/login?error")
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			.deleteCookies("JSESSIONID")
		.and()
		.sessionManagement()
			.maximumSessions(1);
		/*http.sessionManagement()
		  .expiredUrl("/sessionExpired.html");*/
		}
}