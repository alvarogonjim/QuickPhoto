

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;


import aiss.model.api.User;
import aiss.model.resources.UserResource;
import aiss.repository.api.MapUserRepository;

public class UserResourceTest {

	static User user1, user2, user3;
	static MapUserRepository repository = MapUserRepository.getInstance();
	
	
	public void setup() {


	}

	
	@Test
	public void testGetAll() {
		Collection<User> users = repository.getAllUsers();
		
		assertNotNull("The collection of user is null", users);
		
		// Show result
		System.out.println("Listing all users:");
		int i=1;
		for (User u : users) {
			System.out.println("User " + i++ + " : " + u.getName() + " (ID=" + u.getId() + ")");
		}
	}

	@Test
	public void testGetSong() {
		
		// Test song 1
		user1 = new User("nombreUser1","apellidosUser1","emailUser1");
		 repository.addUser(user1);
		
	

		User user = repository.getUser(user1.getId());
		assertEquals("The id of the song does not match", user1.getId(), user.getId());
		
		// Show result
		System.out.println("User name: " +  user.getName());
		System.out.println("User surName: " +  user.getSurName());
		System.out.println("User email: " + user.getEmail());

	}

	@Test
	public void testUpdateSong() {
		
		
		// Test song 1
		user1 = new User("nombreUser1","apellidosUser1","emailUser1");
		 repository.addUser(user1);
		 
		 
		String nombre = "nombre";
		String apellidos = "apellidos";
		String email = "email";
		// Update song
		user1.setName(nombre);
		user1.setSurName(apellidos);
		user1.setEmail(email);
		
		repository.updateUser(user1);
		repository.getUser(user1.getId());
		
		assertEquals("The song's title has not been updated correctly", nombre, user1.getName());
		assertEquals("The song's artist has not been updated correctly", apellidos, user1.getSurName());
		assertEquals("The song's album has not been updated correctly", email, user1.getEmail());
	}

	@Test
	public void testDeleteSong() {
		
		// Test song 1
		user1 = new User("nombreUser1","apellidosUser1","emailUser1");
		 repository.addUser(user1);
		
		// Delete songs
		repository.deleteUser(user1.getId());
	
		User user  = repository.getUser(user1.getId());
		assertNull("The song has not been deleted correctly", user);
	}

}
