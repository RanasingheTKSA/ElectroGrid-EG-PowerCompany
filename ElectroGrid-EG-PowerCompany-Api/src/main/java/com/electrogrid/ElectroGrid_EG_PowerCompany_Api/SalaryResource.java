package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;


import com.electrogrid.model.Salary;
import com.electrogrid.repository.SalaryRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("salary")
public class SalaryResource {
	
SalaryRepository salaryRepository = new SalaryRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Salary> getSalary_s() {
		
	  
		  return salaryRepository.getSalary_s();
	}
	
	@GET
	@Path("salary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Salary> getSalary(@PathParam("id")int id) {
		return salaryRepository.getSalary(id);
	}
	
	@POST
	@Path("add-salary")
	@Consumes (MediaType.APPLICATION_JSON)
	public Salary addNewSalary(Salary salary) {
		System.out.println(salary);
		salaryRepository.addSalary(salary);
		
		return salary;
	}
	
	@PUT
	@Path ("update-salary")
	@Consumes (MediaType.APPLICATION_JSON)
	public String updateSalary(Salary salary) {
		
		return salaryRepository.updateSalary(salary);
	}

	@DELETE
	@Path ("delete-salary/{id}")
	public String deleteSalary (@PathParam("id") int id) {	
		return salaryRepository.detele(id);
				
	} 
}






