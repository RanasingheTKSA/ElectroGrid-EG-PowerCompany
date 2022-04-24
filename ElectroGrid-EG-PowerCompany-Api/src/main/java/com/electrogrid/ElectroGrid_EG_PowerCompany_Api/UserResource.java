package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;

import com.electrogrid.model.User;
import com.electrogrid.repository.UserRepository;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("users")
public class UserResource {

	UserRepository userRepository = new UserRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser(@PathParam("id") int id) {
		return userRepository.getUser(id);
	}
	
	@POST
	@Path("add-user")
	@Consumes (MediaType.APPLICATION_JSON)
	public User addNewUser(User user) {
		System.out.println(user);
		userRepository.addUser(user);
		
		return user;
	}
		
	@PUT
	@Path ("update-user")
	@Consumes (MediaType.APPLICATION_JSON)
	public String updateUser( User user) {
		return userRepository.updateUser(user);
	}
		
	@DELETE
	@Path ("delete-user/{id}")
	public String deleteUser (@PathParam("id") int id) {	
		return userRepository.detele(id);
				
	} 
}