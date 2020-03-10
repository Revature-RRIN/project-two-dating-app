package data;

import java.util.Set;

import beans.Users;

public interface UsersDAO {
	public Integer addUser(Users u);
	public Users getUser(Users u);
	public Users getUserByUandP(String username, String password);
	public Users getUserById(Integer id);
	public Set<Users> getAllUsers();
	public void updateUser(Users u);
	public void deleteUser(Users u);
}
