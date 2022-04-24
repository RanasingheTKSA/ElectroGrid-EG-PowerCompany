package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;



import com.electrogrid.model.Payment;

import com.electrogrid.repository.PaymentRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("payment")
public class PaymentResource {
	
	PaymentRepository paymentRepository = new PaymentRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPayments() {
	
	
		  return paymentRepository.getPayments();
	}
	
	@GET
	@Path("payment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPayment(@PathParam("id")int id) {
		return paymentRepository.getPayment(id);
	}
	
	@POST
	@Path("add-payment")
	@Consumes (MediaType.APPLICATION_JSON)
	public Payment addNewPayment(Payment payment) {
		System.out.println(payment);
		paymentRepository.addPayment(payment);
		
		return payment;
	}
	
	@PUT
	@Path ("update-payment")
	@Consumes (MediaType.APPLICATION_JSON)
	public String updatePayment(Payment payment) {
		
		return paymentRepository.updatePayment(payment);
	}

	@DELETE
	@Path ("delete-payment/{id}")
	public String deletePayment (@PathParam("id") int id) {	
		return paymentRepository.detele(id);
				
	} 
}



