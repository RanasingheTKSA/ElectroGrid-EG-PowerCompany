package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;

import com.electrogrid.model.User;
import com.electrogrid.repository.UserRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
	
	@POST
	@Path("add-user")
	public User addNewUser(User user) {
		System.out.println(user);
		userRepository.addUser(user);
		
		return user;
	}
}
