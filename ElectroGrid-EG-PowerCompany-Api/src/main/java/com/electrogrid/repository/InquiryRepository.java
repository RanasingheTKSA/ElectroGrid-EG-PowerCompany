package com.electrogrid.repository;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.Inquiry;
import com.electrogrid.model.User;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;

public class InquiryRepository {
	
	private Connection connection = null;
	private IDBContext dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public InquiryRepository() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	//get all inquiry from the database
	public List<Inquiry> getInquiries(){
		
		List<Inquiry> inquiries = new ArrayList<Inquiry>();
		String sql = "SELECT * FROM inquiry";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Inquiry inquiry = new Inquiry();
				inquiry.setId(resultSet.getInt(1));
				inquiry.setInquiry_number(resultSet.getString(2));
		        inquiry.setInquiry_date(resultSet.getString(3));
				inquiry.setInquiry_type(resultSet.getString(4));
				inquiry.setInquiry_description(resultSet.getString(5));
				
				inquiries.add(inquiry);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return inquiries;
	}
	// get one Inquiry from the database
		public List<Inquiry> getInquiry(int id){
			
			List<Inquiry> inquiries = new ArrayList<Inquiry>();
			String sql = " SELECT * FROM `electro_grid`.`inquiry` WHERE (`id` = "+id+");";
			try {
				
				//PreparedStatement preparedStatement = connection.prepareStatement(sql);
				//preparedStatement.setInt(1, id);
		
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Inquiry inquiry = new Inquiry();		
					inquiry.setId(resultSet.getInt(1));
					inquiry.setInquiry_number(resultSet.getString(2));
					inquiry.setInquiry_date(resultSet.getString(3));
					inquiry.setInquiry_type(resultSet.getString(4));
					inquiry.setInquiry_description(resultSet.getString(5));
					
					inquiries.add(inquiry);
				}
				//preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return inquiries;
		}
	
	//get inquiry by inquiry id
	//public Inquiry getInquiryById(int id) {
		//return null;
	
	
	//add new users for the data base
	public void addInquiry(Inquiry inquiry) {
		String sql = "insert into inquiry value (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, inquiry.getId());
			preparedStatement.setString(2, inquiry.getInquiry_number());
			preparedStatement.setString(3, inquiry.getInquiry_date());
			preparedStatement.setString(4, inquiry.getInquiry_type());
			preparedStatement.setString(5, inquiry.getInquiry_description());
		
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// update inquiry details
		public String updateInquiry(Inquiry inquiry) {
			
			String sql = "UPDATE `electro_grid`.`inquiry` SET `number` = ?, `date` = ?, `type` = ?, `description` = ?,  WHERE `id` = ?";
			String response = null;
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql); 
				preparedStatement.setString(1, inquiry.getInquiry_number());
				preparedStatement.setString(2, inquiry.getInquiry_date());
				preparedStatement.setString(3, inquiry.getInquiry_type());
				preparedStatement.setString(4, inquiry.getInquiry_description());
				preparedStatement.setInt(7, inquiry.getId());
				
				preparedStatement.executeUpdate();
				
				response = "successfuly update\n"
						+"ID: "+ inquiry.getId()+"\n"
						+"Inquiry_number: "+ inquiry.getInquiry_number()+"\n"
						+"getInquiry_date: "+ inquiry.getInquiry_date()+"\n"
						+"Inquiry_type: "+ inquiry.getInquiry_type()+"\n"
						+"Inquiry_description: "+ inquiry.getInquiry_description()+"\n" ;
						
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return response;
		}
		
		// delete inquiry from the database
		public String detele(int id) {
			
			String sql = "DELETE FROM `electro_grid`.`inquiry` WHERE (`id` = ?);";
			String response = null;
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.executeUpdate();
				
				response = "successfuly Deleted \n";
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return response;
		}
	

	
	
	

	
}
