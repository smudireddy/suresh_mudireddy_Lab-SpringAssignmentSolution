package com.iitr.gl.lab6.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitr.gl.lab6.studentmgmt.entity.Role;

public interface StudentMgmtRoleRepository extends JpaRepository<Role, Long> {

}
