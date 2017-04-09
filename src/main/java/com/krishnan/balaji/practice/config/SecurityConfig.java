package com.krishnan.balaji.practice.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("balaji").password("balaji").roles("admin","dba","user");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/login/**").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/users/**").permitAll()
		.antMatchers("/test/**").permitAll()
		.antMatchers("/secured/**").hasRole("user")
		.and().logout()
		.and().formLogin();
	}
	
	/*
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/signUp").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/signUp")
                .loginProcessingUrl("/login")
                .usernameParameter("fm_userName")
                .passwordParameter("fm_password")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
            .logout()
            	.logoutUrl("/logout")
            	.logoutSuccessUrl("/login")
            	.deleteCookies( "JSESSIONID" )
                .invalidateHttpSession( true )
                .and()
            .csrf().disable();
    }
	.sessionManagement()
    .invalidSessionUrl( "/login?time=1" )
    .maximumSessions( 1 )
    .and()
    .and()*/
	
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }*/
	

}
