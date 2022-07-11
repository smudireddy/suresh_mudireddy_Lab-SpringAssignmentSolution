package com.iitr.gl.lab6.studentmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iitr.gl.lab6.studentmgmt.entity.User;
import com.iitr.gl.lab6.studentmgmt.services.StudentMgmtUserDetailsService;

@Controller
@RequestMapping("/users")
public class StudentMgmtUserController {

	@Autowired
	private StudentMgmtUserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String usersList(Model model) {
		
		System.out.println("----> Users List");
		List<User> users = userDetailsService.fetchAllUsers();
		model.addAttribute("users", users);
		return "userlist";
	}
}
