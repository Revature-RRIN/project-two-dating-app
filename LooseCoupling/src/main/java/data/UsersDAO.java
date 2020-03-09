package data;

import java.util.Set;

import beans.Users;

public interface UsersDAO {
	public Integer addUser(Users u);
	public Users getUser(String username, String password);
	public Users getUser(Users u);
	public Users getUserById(Users u);
	public Set<Users> getMultipleUsers();
	public void updateUser(Users u);
	public void deleteUser(Users u);
}
