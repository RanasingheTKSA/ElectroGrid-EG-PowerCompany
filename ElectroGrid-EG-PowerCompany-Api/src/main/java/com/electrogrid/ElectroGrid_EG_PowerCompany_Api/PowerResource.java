package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;

import com.electrogrid.model.Power;
//import com.electrogrid.model.User;
import com.electrogrid.repository.PowerRepository;
//import com.electrogrid.repository.UserRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("power")
public class PowerResource {

	
PowerRepository powerRepository = new PowerRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Power> getPowers() {
		System.out.println("get power call");
		
		return powerRepository.getPowers();
	}
	
	@GET
	@Path("power/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Power> getPower(@PathParam("id") int id) {
		System.out.println("get one power call");
		return powerRepository.getPower(id);
	}
	
	@POST
	@Path("add-power")
	@Consumes (MediaType.APPLICATION_JSON)
	public Power addNewPower(Power power) {
		System.out.println(power);
		powerRepository.addPower(power);
	
		
		return power;
		
	}
	@PUT
	@Path ("update-power")
	@Consumes (MediaType.APPLICATION_JSON)
	public String updatePower( Power power) {
		System.out.println("done");
		return powerRepository.updatePower(power);
	}
	
	@DELETE
	@Path ("delete-power/{id}")
	@Consumes (MediaType.APPLICATION_JSON)
	public String deletePower (@PathParam("id") int id) {	
		return powerRepository.detele(id);
				
	} 
	
}
