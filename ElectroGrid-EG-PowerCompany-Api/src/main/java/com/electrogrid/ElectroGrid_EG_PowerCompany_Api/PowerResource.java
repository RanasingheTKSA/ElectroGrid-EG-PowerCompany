package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;

import com.electrogrid.model.Power;
import com.electrogrid.model.User;
import com.electrogrid.repository.PowerRepository;
import com.electrogrid.repository.UserRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("power")


public class PowerResource {

	
PowerRepository powerRepository = new PowerRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Power> getPower() {
		System.out.println("get power call");
		
		return powerRepository.getPowers();
	}
	
	@POST
	@Path("addpower")
	public Power addNewPower(Power power) {
		System.out.println(power);
		powerRepository.addPower(power);
	//System.out.println("post power call");
		
		return power;
	}
}
