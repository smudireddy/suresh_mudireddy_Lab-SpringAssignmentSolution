package com.iitr.gl.lab6.studentmgmt.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.iitr.gl.lab6.studentmgmt.entity.User;
import com.iitr.gl.lab6.studentmgmt.repository.UserRepository;
import com.iitr.gl.lab6.studentmgmt.security.StudentMgmtUserDetails;

public class StudentMgmtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findUserByName(username);
		UserDetails details = new StudentMgmtUserDetails(user);
		return details;
	}

}
