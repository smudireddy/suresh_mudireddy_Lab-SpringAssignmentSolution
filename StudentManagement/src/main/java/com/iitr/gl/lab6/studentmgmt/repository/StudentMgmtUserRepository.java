package com.iitr.gl.lab6.studentmgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitr.gl.lab6.studentmgmt.entity.User;

public interface StudentMgmtUserRepository  extends JpaRepository<User, Long>{
  
	Optional<User> findUserByName(String userName); 
}
