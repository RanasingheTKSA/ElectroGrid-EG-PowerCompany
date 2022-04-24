package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;


import java.util.List;

import com.electrogrid.model.MonthlyBill;
import com.electrogrid.model.User;
import com.electrogrid.repository.MonthlyBillRepository;
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

@Path ("monthlybill")
public class MonthlyBillResource {

	MonthlyBillRepository monthlybillRepository = new MonthlyBillRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MonthlyBill> getMonthlyBills() {
		return monthlybillRepository.getMonthlyBill();
	}
	
	@GET
	@Path("monthlybill/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  List <MonthlyBill> getMonthlyBill(@PathParam("id")int id) {
		return monthlybillRepository.getMonthlyBill(id);
	}
	
	@POST
	@Path("add-monthlybill")
	@Consumes (MediaType.APPLICATION_JSON)
	public MonthlyBill addNewMonthlyBill(MonthlyBill monthlybill) {
		System.out.println(monthlybill);
		monthlybillRepository.addMonthlyBill(monthlybill);
		
		return monthlybill;
	}
	
	@PUT
	@Path ("update-monthlybill")
	@Consumes (MediaType.APPLICATION_JSON)
	public String updateMonthlyBill(MonthlyBill monthlybill) {
		return monthlybillRepository.updateMonthlyBill(monthlybill);
		}
	
	@DELETE
	@Path ("delete-monthlybill/{id}")
	public String deleteMonthlyBill (@PathParam("id") int id) {	
		return monthlybillRepository.detele(id);
				
	} 
}
