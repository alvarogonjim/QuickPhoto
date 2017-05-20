package aiss.repository.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ls.LSOutput;

import aiss.model.api.User;


public class MapUserRepository implements UserRepository{

	Map<String, User> userMap;
	private static MapUserRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapUserRepository getInstance() {
		
		if (instance==null) {
			instance = new MapUserRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		userMap = new HashMap<String,User>();
		
		//Create Users
		User u1 = new User("Alvaro","Gonzalez","alvarogonjim95@gmail.com");
		addUser(u1);
		
		User u2 = new User("Francisco","Piña","franmpina@gmail.com");
		addUser(u2);
		
		User u3 = new User("Cristian","Osorno","crisos@gmail.com");
		addUser(u3);
		
		User u4 = new User("Alejandro","Martin","alemartin@gmail.com");
		addUser(u4);
		
		User u5 = new User("Daniel","Sanchez","dansanchez@gmail.com");
		addUser(u5);
		
	
	}
	
	@Override
	public void addUser(User u) {
		String id = "s" + index++;
		u.setId(id);
		userMap.put(id, u);
		
	}

	@Override
	public Collection<User> getAllUsers() {
		return userMap.values();
	}

	@Override
	public User getUser(String userId) {
		return userMap.get(userId);
	}

	@Override
	public void updateUser(User s) {
		User user = userMap.get(s.getId());
		user.setName(s.getName());
		user.setSurName(s.getSurName());
		user.setEmail(s.getEmail());	
	}

	@Override
	public void deleteUser(String userId) {
		userMap.remove(userId);
		
	}
	
}
