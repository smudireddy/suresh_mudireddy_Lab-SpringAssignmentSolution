package com.iitr.gl.lab6.studentmgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class StudentManagementWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().headers().frameOptions().disable();
		
		http.anonymous().and().authorizeRequests().anyRequest().permitAll();
		/*
		http.anonymous().and().authorizeRequests().antMatchers("/login**", "/logout**", "/contact-us**", "/login/**").permitAll()
				.antMatchers(HttpMethod.GET, "/students**").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/students**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN").anyRequest().authenticated().and()
				.formLogin().and().httpBasic();
			*/	
	}

	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
				.and().withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER").and()
				.withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
