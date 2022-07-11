package com.iitr.gl.lab6.studentmgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iitr.gl.lab6.studentmgmt.servicesimpl.StudentMgmtUserDetailsService;

@Configuration
@EnableWebSecurity
public class StudentManagementWebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService studentMgmtUserDetailsService;
	
	public StudentManagementWebSecurityConfig(StudentMgmtUserDetailsService studentMgmtUserDetailsService) {
        this.studentMgmtUserDetailsService = studentMgmtUserDetailsService;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.anonymous()
			.and()
			.authorizeRequests()
			.antMatchers("/", "/students","/students/accessdenied").hasAnyRole("USER", "ADMIN")
			.antMatchers("/students/register", 
					"/students/update", 
					"/students/deregister")
			.hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
				.formLogin()
					.loginProcessingUrl("/login")
					.successForwardUrl("/")
					.permitAll()
			.and().logout().logoutSuccessUrl("/login").permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/students/accessdenied")
			.and()
			.exceptionHandling().accessDeniedPage("/students/accessdenied")
			.and().cors().and().csrf().disable();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.studentMgmtUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
