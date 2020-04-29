package com.springreddit.repositories;

	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;
	import com.springreddit.beans.users;

	@Repository
	public interface usersrep extends JpaRepository<users, Integer>{
		
		/**
		 * Custom query that uses the @Query annotation to select a user by username.
		 * 
		 * @param username represents the user's username.
		 * @return Check {@link com.userserviceimpl.services.impl.UserServiceImpl}
		 */
		
		@Query("select u from users u where u.username = ?1")
		public List<users> getUserByUsername(String username);
		


}
