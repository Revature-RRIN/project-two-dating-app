package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.services.UsersService;
import com.revature.services.UsersServiceHibernate;

@RestController
@RequestMapping(value="/signup")
@CrossOrigin(origins="http://localhost:4200")
public class SignupController {
	public static void main(String[] args) {
		UsersService us = new UsersServiceHibernate();
		Users u2 = new Users("test4","pass","aron","cal",2,3,"a");
		System.out.println(us.addUser(u2));
		
	}
	
	@Autowired
	private UsersService us;
	
	@PostMapping
	public ResponseEntity<Users> signup(@RequestBody Users u){
		return ResponseEntity.status(201).body(us.addUser(u));
	}

}
