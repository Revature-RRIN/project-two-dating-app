package com.revature.services;

import java.util.Set;

import com.revature.beans.Users;

public interface UsersService {
	public Users addUser(Users u);
	public Users getUser(String username, String pass);
	public Users getUserById(int id);
	public Set<Users> getAllUsers();
	public void updateUser(Users u);
	public void deleteUser(Users u);
}
