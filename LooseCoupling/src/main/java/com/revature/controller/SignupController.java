package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.services.UsersService;
import com.revature.services.UsersServiceHibernate;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SignupController {
	public static void main(String[] args) {
		UsersService us = new UsersServiceHibernate();
		Users u1 = new Users("kjdflj", "kljdf");
		Users u2 = new Users();
		Users u3 = new Users("a", "b", 1, 1, "loc");
		us.addUser(u1);
		
		u1 = u3;
		u1.setUsersId(9);
		u2 = us.updateUser(u1);	
		System.out.println(u1);	
		System.out.println(u2);
		
	
		
		
	}
	
	@Autowired
	private UsersService us;
	
	@PostMapping(value="/signup")
	public ResponseEntity<Users> signup(@RequestBody Users u){
		return ResponseEntity.status(201).body(us.addUser(u));
	}
	
	@PutMapping(value="/profile/{usersId}")
	public ResponseEntity<Users> updateUser(@PathVariable("usersId") Integer id, @RequestBody Users u) {
		System.out.println(u);
		us.updateUser(u);
		return ResponseEntity.ok(us.getUserById(id));

	}
}