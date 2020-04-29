package com.springreddit.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.maps.errors.ApiException;
import com.revature.beans.User;
import com.revature.services.DistanceService;
import com.revature.services.UserService;
import com.revature.services.ValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
@CrossOrigin
@SessionAttributes(value= "user")

//get: get user
//post, make user
//update user
//delete user

public class UserController {
    
    @Autowired
    //private, name, putyourservices here
	
	/**
	 * HTTP GET method (/users)
	 * 
	 * @param isDriver represents if the user is a driver or rider.
	 * @param username represents the user's username.
	 * @param location represents the batch's location.
	 * @return A list of all the users, users by is-driver, user by username and users by is-driver and location.
	 */
	
	@GetMapping
	public List<User> getUsers(@RequestParam(name="is-driver",required=false)Boolean isDriver,
							   @RequestParam(name="username",required=false)String username,
							   @RequestParam(name="location", required=false)String location) {
		
		if (isDriver != null && location != null) {
			return us.getUserByRoleAndLocation(isDriver.booleanValue(), location);
		} else if (isDriver != null) {
			return us.getUserByRole(isDriver.booleanValue());
		} else if (username != null) {
			return us.getUserByUsername(username);
		}
		
		return us.getUsers();
	}
	
	/**
	 * HTTP GET (users/{id})
	 * 
	 * @param id represents the user's id.
	 * @return A user that matches the id.
	 */
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")int id) {
		
		return us.getUserById(id);
	}
	
	/**
	 * HTTP POST method (/users)
	 * 
	 * @param user represents the new User object being sent.
	 * @return The newly created object with a 201 code.
	 * 
	 * Sends custom error messages when incorrect input is used
	 */
	
	@PostMapping
	public ResponseEntity addUser(@Valid @RequestBody User user, BindingResult result) {
            if (errors.isEmpty()){
                    return ResponseEntity.status(HttpStatus.CREATED).body(
                            us.addUser(user));
            } 
            else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
	/**
	 * HTTP PUT method (/users)
	 * 
	 * @param user represents the updated User object being sent.
	 * @return The newly updated object.
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity updateUser(@Valid @RequestBody User user, BindingResult result) {
            Map<String, List<String>> errors = validationService.validate(result);
            if (errors.isEmpty()){
                return ResponseEntity.ok(us.updateUser(user));
            } 
            else {
                return ResponseEntity.badRequest().body(errors);
            }
	}
	
	/**
	 * HTTP DELETE method (/users)
	 * 
	 * @param id represents the user's id.
	 * @return A string that says which user was deleted.
	 */
	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id")int id) {
		
		return us.deleteUserById(id);
	}
	
}
