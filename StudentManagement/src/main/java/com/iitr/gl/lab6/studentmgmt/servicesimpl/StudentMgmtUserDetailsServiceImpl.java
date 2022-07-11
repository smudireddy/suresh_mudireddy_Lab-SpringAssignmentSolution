package com.iitr.gl.lab6.studentmgmt.servicesimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iitr.gl.lab6.studentmgmt.entity.User;
import com.iitr.gl.lab6.studentmgmt.repository.StudentMgmtUserRepository;
import com.iitr.gl.lab6.studentmgmt.security.StudentMgmtUserDetails;
import com.iitr.gl.lab6.studentmgmt.services.StudentMgmtUserDetailsService;

@Service
public class StudentMgmtUserDetailsServiceImpl implements UserDetailsService, StudentMgmtUserDetailsService {

	@Autowired
	private StudentMgmtUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("invalid username"));;
		UserDetails details = new StudentMgmtUserDetails(user);
		return details;
	}

	@Override
	public List<User> fetchAllUsers() {
		return repository.findAll();
	}

}
