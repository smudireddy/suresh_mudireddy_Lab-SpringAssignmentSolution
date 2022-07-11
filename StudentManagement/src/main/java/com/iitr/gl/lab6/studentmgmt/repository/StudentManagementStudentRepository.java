package com.iitr.gl.lab6.studentmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iitr.gl.lab6.studentmgmt.entity.Student;

public interface StudentManagementStudentRepository extends JpaRepository<Student, Long>{
   
	 @Query("select s from Student s where lower(s.firstName) like lower(concat('%', :search, '%')) " +
			 "or lower(s.lastName) like lower(concat('%', :search, '%'))")
     List<Student> findByFirstNameOrLastName(@Param("search") String search);
}
