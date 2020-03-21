package com.revature.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.services.UsersService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UsersController {
	@Autowired
	private UsersService us;
	
	@GetMapping(value="/users")
	public ResponseEntity<Set<Users>> getAllUsers() {
		return ResponseEntity.ok(us.getAllUsers());
	}
}
