package aiss.repository.api;

import java.util.Collection;

import aiss.model.api.User;

public interface UserRepository {
	
	
	// User
	public void addUser(User u);
	public Collection<User> getAllUsers();
	public User getUser(String userId);
	public void updateUser(User s);
	public void deleteUser(String userId);
		
	
	
	

}
