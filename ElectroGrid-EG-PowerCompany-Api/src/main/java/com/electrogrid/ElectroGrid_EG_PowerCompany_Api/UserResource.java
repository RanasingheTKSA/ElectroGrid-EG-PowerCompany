package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;


import com.electrogrid.model.User;
import com.electrogrid.repository.UserRepository;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("user")
public class UserResource {

	UserRepository userRepository = new UserRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser() {
		System.out.println("get user call");
		
		return userRepository.getUsers();
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id")int id) {
		return userRepository.getUserById(id);
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
	public User updaUser(User user) {
		System.out.println(user);
		
//		if (userRepository.getUsers(user.getId()) == null) {
//			userRepository.addUser(user);
//		}else {
//			userRepository.update(user);
//		}		
		return user;
	}
}
