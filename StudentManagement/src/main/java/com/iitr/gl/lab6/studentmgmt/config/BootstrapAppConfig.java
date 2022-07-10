package com.iitr.gl.lab6.studentmgmt.config;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iitr.gl.lab6.studentmgmt.entity.Role;
import com.iitr.gl.lab6.studentmgmt.entity.User;
import com.iitr.gl.lab6.studentmgmt.repository.StudentMgmtUserRepository;

@Configuration
public class BootstrapAppConfig implements ApplicationListener<ApplicationReadyEvent> {

	/*
	 * private StudentMgmtUserRepository userRepository; private PasswordEncoder
	 * passwordEncoder;
	 * 
	 * BootstrapAppConfig(StudentMgmtUserRepository userRepository) {
	 * this.userRepository = userRepository; this.passwordEncoder = new
	 * BCryptPasswordEncoder(); }
	 */
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		
	}
}
