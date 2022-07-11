package com.iitr.gl.lab6.studentmgmt.services;

import java.util.List;

import com.iitr.gl.lab6.studentmgmt.entity.Role;
import com.iitr.gl.lab6.studentmgmt.entity.User;

public interface StudentMgmtUserDetailsService {
	
	List<User> fetchAllUsers();
	List<Role> fetchAllRoles();
}
