package Services;

import java.util.Set;

import beans.Users;
import data.UsersDAO;
import data.UsersHibernate;

@Service
public class UsersServiceHibernate implements UsersService{
	private UsersDAO ud = new UsersHibernate();
	
	public void addUser(Users u) {
		ud.addUser(u);
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

	public void updateUser(Users u) {
		ud.updateUser(u);
		
	}

	public void deleteUser(Users u) {
		ud.deleteUser(u);
		
	}

}
