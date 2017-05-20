package aiss.model.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.NotFoundException;

import com.google.api.server.spi.response.BadRequestException;

import aiss.model.api.User;
import aiss.repository.api.MapUserRepository;
import aiss.repository.api.UserRepository;

@Path("/user")
public class UserResource {

		public static UserResource _instance=null;
		UserRepository repository;
		
		private UserResource(){
			repository=MapUserRepository.getInstance();
		}
		
		public static UserResource getInstance()
		{
			if(_instance==null)
				_instance=new UserResource();
			return _instance; 
		}
		
		@GET
		@Produces("application/json")
		public Collection<User> getAll()
		{
			return repository.getAllUsers();
		}
		
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public User get(@PathParam("id") String userId)
		{
			
			User u = repository.getUser(userId);
			if(u == null){
				throw new NotFoundException("The user with id: " + userId + " was not found");
			}
			return u;
		}
		
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public Response addUser(@Context UriInfo uriInfo, User user){
			
			if(user == null || "".equals(user.getName()) || "".equals(user.getEmail()) || "".equals(user.getSurName() ))
				throw new org.jboss.resteasy.spi.BadRequestException("No valid empty values");
					
			
			repository.addUser(user);
			//Build the response. Return the user that he/she added.
			
			UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
			URI uri = ub.build(user.getId());
			ResponseBuilder resp = Response.created(uri);
			resp.entity(user);
			return resp.build();
		
		}
		
		
		@PUT
		@Consumes("application/json")
		public Response updateUser(User user) {
			User u = repository.getUser(user.getId());
			
			if(u == null){
				throw new NotFoundException("The user with id: " + user.getId() + " was not found");
			}
			
			//Update name
			if(user.getName()!=null){
				u.setName(user.getName());
			}
			
			//Update surname
			if(user.getSurName()!=null){
				u.setSurName(user.getSurName());
			}
			
			//Update email
			if(user.getEmail()!=null){
				u.setEmail(user.getEmail());
			}
			return Response.noContent().build();
			
			
		}
		
		@DELETE
		@Path("/{id}")
		public Response removeUser(@PathParam("id") String userId) {
			return null;
		}

	
}
