package com.iitr.gl.lab6.studentmgmt.services;

import java.util.List;

import com.iitr.gl.lab6.studentmgmt.entity.Student;

public interface StudentManagementStudentService {
  
	List<Student> getAllStudents();
	Student getStudentById(Long studentId);
	void deleteStudentById(Long studentId);
	void addStudent(Student student);
	void updateStudent(Student student);
	List<Student> findByFirstNameOrLastName(String searchStr);
}
