package Services;

import java.util.Set;

import beans.Users;

public interface UsersService {
	public void addUser(Users u);
	public Users getUser(String username, String pass);
	public Users getUserById(int id);
	public Set<Users> getAllUsers();
	public void updateUser(Users u);
	public void deleteUser(Users u);
}
