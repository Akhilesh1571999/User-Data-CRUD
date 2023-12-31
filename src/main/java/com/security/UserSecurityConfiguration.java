package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
        .withUser("user").password("{1234}password").roles("USER")
        .and()
        .withUser("admin").password("{1234}password").roles("USER", "ADMIN");

    }
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

	      http
	      .httpBasic()
	      .and()
	      .authorizeRequests()
	      .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
	      .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN")
	      .antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
	      .antMatchers(HttpMethod.GET).hasAnyRole("USER")
	      .and()
	      .csrf().disable()
	      .formLogin().disable();
	      
	    }

	 
	 @Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}
