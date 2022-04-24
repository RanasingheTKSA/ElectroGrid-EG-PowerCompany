package com.electrogrid.repository;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.MonthlyBill;



public class MonthlyBillRepository {
	
	private Connection connection = null;
	private IDBContext dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public MonthlyBillRepository() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	//get all users from the database
	public List<MonthlyBill> getMonthlyBill(){
		
		List<MonthlyBill> monthlybills = new ArrayList<MonthlyBill>();
		String sql = "SELECT * FROM monthlybill";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				MonthlyBill monthlybill = new MonthlyBill();
				
				monthlybill.setId(resultSet.getInt(1));
				monthlybill.setAccount_number(resultSet.getString(2));
				monthlybill.setDate(resultSet.getString(3));
				monthlybill.setNo_of_units(resultSet.getString(4));
				monthlybill.setCharge_of_the_month(resultSet.getString(5));
				monthlybill.setTotal_amount(resultSet.getString(6));
			
				
				monthlybills.add(monthlybill);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return monthlybills;
	}
	
	// get one monthlybill from the database
		public List<MonthlyBill> getMonthlyBill(int id){
			
			List<MonthlyBill> monthlybills = new ArrayList<MonthlyBill>();
			String sql = " SELECT * FROM `electro_grid`.`monthlybill` WHERE (`id` = "+id+");";
			try {
				
				//PreparedStatement preparedStatement = connection.prepareStatement(sql);
				//preparedStatement.setInt(1, id);
		
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					MonthlyBill monthlybill = new MonthlyBill();		
					monthlybill.setId(resultSet.getInt(1));
					monthlybill.setAccount_number(resultSet.getString(2));
					monthlybill.setDate(resultSet.getString(3));
					monthlybill.setNo_of_units(resultSet.getString(4));
					monthlybill.setCharge_of_the_month(resultSet.getString(5));
					monthlybill.setTotal_amount(resultSet.getString(6));
				
					
					monthlybills.add(monthlybill);
				}
				//preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return monthlybills;
		}

	
	//add new MonthlyBill for the data base
	public void addMonthlyBill(MonthlyBill monthlybill) {
		String sql = "insert into monthlybill value (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,monthlybill.getId());
			preparedStatement.setString(2,monthlybill.getAccount_number());
			preparedStatement.setString(3,monthlybill.getDate());
			preparedStatement.setString(4,monthlybill.getNo_of_units());
			preparedStatement.setString(5,monthlybill.getCharge_of_the_month());
			preparedStatement.setString(6,monthlybill.getTotal_amount());
		
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	// update monthlybill details
		public String updateMonthlyBill(MonthlyBill monthlybill) {
			
			String sql = "UPDATE `electro_grid`.`monthlybill` SET `account_number` = ?, `date` = ?, `no_of_units` = ?, `charge_of_the_month` = ?, `total_amount` =? WHERE `id` = ?";
			String response = null;
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql); 
				preparedStatement.setString(1, monthlybill.getAccount_number());
				preparedStatement.setString(2, monthlybill.getDate());
				preparedStatement.setString(3, monthlybill.getNo_of_units());
				preparedStatement.setString(4, monthlybill.getCharge_of_the_month());
				preparedStatement.setString(5, monthlybill.getTotal_amount());
				preparedStatement.setInt(7, monthlybill.getId());
				
				preparedStatement.executeUpdate();
				
				response = "successfuly update\n"
						+"ID: "+ monthlybill.getId()+"\n"
						+"Account_number: "+ monthlybill.getAccount_number()+"\n"
						+"Date: "+ monthlybill.getDate()+"\n"
						+"No_of_units: "+ monthlybill.getNo_of_units()+"\n"
						+"Charge-of_the_month: "+ monthlybill.getCharge_of_the_month()+"\n" 
						+"Total_amount: "+ monthlybill.getTotal_amount()+"\n" ;
						
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return response;
		}
		
		// delete monthlybill from the database
		public String detele(int id) {
			
			String sql = "DELETE FROM `electro_grid`.`monthlybill` WHERE (`id` = ?);";
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
