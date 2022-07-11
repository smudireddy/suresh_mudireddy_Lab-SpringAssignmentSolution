package com.iitr.gl.lab6.studentmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iitr.gl.lab6.studentmgmt.entity.Student;
import com.iitr.gl.lab6.studentmgmt.services.StudentManagementStudentService;

@Controller
public class StudentManagementStudentController {

	@Autowired
	private StudentManagementStudentService managementStudentService;

	@RequestMapping(value = { "/", "/students" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String showStudentsList(Model model) {
		List<Student> students = managementStudentService.getAllStudents();
		model.addAttribute("students", students);
		return "studentlist";
	}
	
	@RequestMapping("/students/accessdenied")
	public String  showAccessdeniedMessage() {
		return "accessdenied";
	}

	
	@GetMapping("/students/register")
	public String showStudentRegisterationForm(Model model) {
		model.addAttribute("student",new Student());
		return "studentRegForm";
	}
	
	@GetMapping("students/update")
	public String showStudentUpdateFrom(@RequestParam("studentId") long studentId, Model model) {

		Student student = managementStudentService.getStudentById(studentId);
		model.addAttribute("student", student);
		return "studentRegForm";
	}
	
	@RequestMapping(value = { "/students/register", "/students/update" }, method = RequestMethod.POST)
	public String addStudentRegisteration(@ModelAttribute("student") Student student, Model model) {
		
		if(student.getId() == 0) {
			managementStudentService.addStudent(student);
		}
		else {
			managementStudentService.updateStudent(student);
		}
		return "redirect:/students";
	}
	
	@RequestMapping(value = { "/students/deregister" }, method = RequestMethod.GET)
	public String addStudentRegisteration(@RequestParam("studentId") long studentId, Model model) {
		managementStudentService.deleteStudentById(studentId);
		return "redirect:/students";
	}
	
	@GetMapping("/students/search") 
	
	String findStudentsByKey(@RequestParam("searchkey") String searchKey, Model model) {
		
		List<Student> students = managementStudentService.findByFirstNameOrLastName(searchKey);
		model.addAttribute("students", students);
		return "studentlist";
	}
}
