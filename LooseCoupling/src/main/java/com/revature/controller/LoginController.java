package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.data.hibernate.UsersHibernate;
import com.revature.data.hibernate.UsersServiceHibernate;
import com.revature.services.UsersService;

@RestController
@RequestMapping(value="/login")
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	public static void main(String[] args)	{
		UsersService us = new UsersServiceHibernate();
		Users u = us.getUser("username", "pass");
		System.out.println(u.getFirstname());
	}
	
	
	@Autowired
	private UsersService us;
	/*@Autowired
	private UserService cs;
	@Autowired
	private EmployeeService es;*/
	
	@GetMapping
	public ResponseEntity<Users> login(HttpSession session) {
		Users l = (Users) session.getAttribute("loggedUser");
		if(l == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(l);
	}
	
	@PostMapping
	public ResponseEntity<Users> login(@RequestParam("user") String username, 
			@RequestParam("pass") String password, HttpSession session) {
		Users c = us.getUser(username,  password);
		if(c==null) {
			return ResponseEntity.status(401).build();
		}
		Users loggedUser = new Users(username, password);
		session.setAttribute("loggedUser", loggedUser);
		return ResponseEntity.ok(loggedUser);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
}
