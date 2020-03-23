package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Users;
import com.revature.data.UsersDAO;
import com.revature.data.hibernate.UsersHibernate;

@Service
public class UsersServiceHibernate implements UsersService{
	private UsersDAO ud = new UsersHibernate();
	
	public Users addUser(Users u) {
		return ud.getUserById(ud.addUser(u));
	}

	public Users getUser(String username, String pass) {
		Users u = new Users(username, pass);
		u = (Users) ud.getUser(u);
		return u;
	}

	public Users getUserById(int id) {
		Users u = new Users(id);
		u = (Users) ud.getUser(u);
		return u;
	}

	public Set<Users> getAllUsers() {
		return ud.getAllUsers();
	}

	public Users updateUser(Users u) {
		return ud.updateUser(u);	
	}

	public void deleteUser(Users u) {
		ud.deleteUser(u);
		
	}

	@Override
	public Users findCompatibleUser(Users u) {
		return ud.getCompatibleUser(u);
	}

	@Override
	public Set<Users> getCompatibleUserGroup(Users u) {
		return ud.getCompatibleUserGroup(u);
	}

}
