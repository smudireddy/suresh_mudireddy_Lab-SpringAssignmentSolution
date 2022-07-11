package com.iitr.gl.lab6.studentmgmt.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.iitr.gl.lab6.studentmgmt.entity.Student;
import com.iitr.gl.lab6.studentmgmt.repository.StudentManagementStudentRepository;
import com.iitr.gl.lab6.studentmgmt.services.StudentManagementStudentService;

@Service
public class StudentManagementStudentServiceImpl implements StudentManagementStudentService {

	@Autowired
	private StudentManagementStudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.getById(studentId);
	}

	@Override
	public void deleteStudentById(Long studentId) {
		Student student = studentRepository.getById(studentId);
		if(student != null) {
			studentRepository.delete(student);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void updateStudent(Student theStudent) {
		
		Student student =  studentRepository.getById(theStudent.getId());
		if(student != null) {
			student.setFirstName(theStudent.getFirstName());
			student.setLastName(theStudent.getLastName());
			student.setCourse(theStudent.getCourse());
			student.setCountry(theStudent.getCountry());
			studentRepository.save(student);
		}
		else {
			studentRepository.save(theStudent);
		}
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> findByFirstNameOrLastName(String searchStr) {
		return studentRepository.findByFirstNameOrLastName(searchStr);
	}	
}
