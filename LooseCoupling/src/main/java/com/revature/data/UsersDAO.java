package com.revature.data;

import java.util.Set;

import com.revature.beans.Users;

public interface UsersDAO {
	public Integer addUser(Users u);
	public Users getUser(Users u);
	public Users getUserByUandP(String username, String password);
	public Users getUserById(Integer id);
	public Set<Users> getAllUsers();
	public Users updateUser(Users u);
	public void deleteUser(Users u);
	public Users getCompatibleUser(Users u);
	public Set<Users> getCompatibleUserGroup(Users u);
}
