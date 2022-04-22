package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("user")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		System.out.println("get user call");
		
		User user = new User();
		user.setId("U001");
		user.setUser_name("Ranasinghe TKSA");
		user.setUser_nic("982570590V");
		user.setUser_address("Arakavila, Handapangoda");
		user.setUser_zip_code("12400");
		user.setUser_contact_number("0712838354");
		user.setUser_email("sachin@gmail.com");
		
		return user;
	}
}
