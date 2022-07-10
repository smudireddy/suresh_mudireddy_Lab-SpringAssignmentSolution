package com.iitr.gl.lab6.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitr.gl.lab6.studentmgmt.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
  
	User findUserByName(String userName); 
}
