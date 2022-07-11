package com.iitr.gl.lab6.studentmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iitr.gl.lab6.studentmgmt.entity.Role;
import com.iitr.gl.lab6.studentmgmt.entity.User;
import com.iitr.gl.lab6.studentmgmt.services.StudentMgmtUserDetailsService;

@Controller
@RequestMapping("/users")
public class StudentMgmtUserController {

	@Autowired
	private StudentMgmtUserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String usersList(Model model) {
		List<User> users = userDetailsService.fetchAllUsers();
		model.addAttribute("users", users);
		return "userlist";
	}
	
	@GetMapping("/accessdenied")
	public String  showAccessdeniedMessage() {
		return "accessdenied";
	}
	
	@GetMapping("/adduser")
	public String showUserAddForm(Model model) {
		
		model.addAttribute("user", new User());
		List<Role> roles = userDetailsService.fetchAllRoles();
		model.addAttribute("roles",roles);
		return "adduserform";
	}
	
	/*
	@RequestMapping(value = { "/users/register", "/users/update" }, method = RequestMethod.POST)
	public String addStudentRegisteration(@RequestParam("userI"), Model model) {
		
		if(student.getId() == 0) {
			managementStudentService.addStudent(student);
		}
		else {
			managementStudentService.updateStudent(student);
		}
		return "redirect:/students";
	}
	*/
}
