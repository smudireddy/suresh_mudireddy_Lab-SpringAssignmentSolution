package com.iitr.gl.lab6.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitr.gl.lab6.studentmgmt.entity.Student;

public interface StudentManagementStudentRepository extends JpaRepository<Student, Long>{
   
}
