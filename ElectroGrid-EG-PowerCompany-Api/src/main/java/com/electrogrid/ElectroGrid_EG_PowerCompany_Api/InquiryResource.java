package com.electrogrid.ElectroGrid_EG_PowerCompany_Api;

import java.util.List;

import com.electrogrid.model.Inquiry;
import com.electrogrid.repository.InquiryRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("inquiry")
public class InquiryResource {

	InquiryRepository inquiryRepository = new InquiryRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inquiry> getInquiry() {
	       return inquiryRepository.getInquiries();
	}
	
	@GET
	@Path("inquiry/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inquiry>getInquiry(@PathParam("id")int id) {
		return inquiryRepository.getInquiry(id);
	}
	
	@POST
	@Path("add-inquiry")
	@Consumes (MediaType.APPLICATION_JSON)
	public Inquiry addNewInquiry(Inquiry inquiry) {
		System.out.println(inquiry);
		inquiryRepository.addInquiry(inquiry);
		
		return inquiry;
	}
	
	@PUT
	@Path ("update-inquiry")
	@Consumes (MediaType.APPLICATION_JSON)
	public String updateInquiry(Inquiry inquiry) {
		return inquiryRepository.updateInquiry(inquiry);
	}
		
	@DELETE
	@Path ("delete-inquiry/{id}")
	public String deleteInquiry (@PathParam("id") int id) {	
	return inquiryRepository.detele(id);
							
				
				
				
				
	}
}
