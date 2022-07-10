package com.iitr.gl.lab6.studentmgmt.servicesimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iitr.gl.lab6.studentmgmt.entity.User;
import com.iitr.gl.lab6.studentmgmt.repository.StudentMgmtUserRepository;
import com.iitr.gl.lab6.studentmgmt.security.StudentMgmtUserDetails;

@Service
public class StudentMgmtUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentMgmtUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("invalid username"));;
		UserDetails details = new StudentMgmtUserDetails(user);
		return details;
	}

}
