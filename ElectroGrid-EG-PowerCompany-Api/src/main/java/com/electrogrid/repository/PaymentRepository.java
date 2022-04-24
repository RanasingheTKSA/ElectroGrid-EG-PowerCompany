package com.electrogrid.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.Payment;


public class PaymentRepository {
	
	
		
		private Connection connection = null;
		private IDBContext dbContext;
		private Statement statement;
		private ResultSet resultSet;
		private static PreparedStatement preparedStatement = null;
		
		public PaymentRepository() {
			super();
			this.dbContext = new DatabaseConnection();
			this.connection = dbContext.getDatabaseConnection();
			
		}
		
		//get all payments from the database
		public List<Payment> getPayments(){
			
			List<Payment> payments = new ArrayList<Payment>();
			String sql = "SELECT * FROM payment";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Payment payment = new Payment();
					payment.setId(resultSet.getInt(1));
					payment.setName(resultSet.getString(2));
					payment.setAccount_no(resultSet.getString(3));
					payment.setAmount(resultSet.getString(4));
					payment.setCard_no(resultSet.getString(5));
					payment.setSecurity_code(resultSet.getString(6));
					payment.setExpiration_date(resultSet.getString(7));
					
					payments.add(payment);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return payments;
		}
		
		// get one payment from the database
		public List<Payment> getPayment(int id){
			
			List<Payment> payments = new ArrayList<Payment>();
			String sql = " SELECT * FROM `electro_grid`.`payment` WHERE (`id` = "+id+");";
			try {
				
				//PreparedStatement preparedStatement = connection.prepareStatement(sql);
				//preparedStatement.setInt(1, id);
		
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Payment payment = new Payment();		
					payment.setId(resultSet.getInt(1));
					payment.setName(resultSet.getString(2));
					payment.setAccount_no(resultSet.getString(3));
					payment.setAmount(resultSet.getString(4));
					payment.setCard_no(resultSet.getString(5));
					payment.setSecurity_code(resultSet.getString(6));
					payment.setExpiration_date(resultSet.getString(7));
					
					payments.add(payment);
				}
				//preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return payments;
		}
		
		//get user by payment id
		//public Payment getPaymentById(int id) {
	//		return null;
	//	}
		
		//add new payments for the data base
		public void addPayment(Payment payment) {
			String sql = "insert into payment value (?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1,	payment.getId());
				preparedStatement.setString(2,payment.getName());
				preparedStatement.setString(3,payment.getAccount_no());
				preparedStatement.setString(4,payment.getAmount());
				preparedStatement.setString(5,payment.getCard_no());
				preparedStatement.setString(6,payment.getSecurity_code());
				preparedStatement.setString(7,payment.getExpiration_date());
				
				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		// update payment details
		public String updatePayment(Payment payment) {
			
			String sql = "UPDATE `electro_grid`.`payment` SET `name` = ?, `account_no` = ?, `amount` = ?, `card_no` = ?, `security_code` =? , `expiration_date` = ? WHERE `id` = ?";
			String response = null;
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql); 
				preparedStatement.setString(1, payment.getName());
				preparedStatement.setString(2, payment.getAccount_no());
				preparedStatement.setString(3, payment.getAmount());
				preparedStatement.setString(4, payment.getCard_no());
				preparedStatement.setString(5, payment.getSecurity_code());
				preparedStatement.setString(6, payment.getExpiration_date());
				preparedStatement.setInt(7, payment.getId());
				
				preparedStatement.executeUpdate();
				
				response = "successfuly update\n"
						+"ID: "+ payment.getId()+"\n"
						+"Name: "+ payment.getName()+"\n"
						+"Account_no: "+ payment.getAccount_no()+"\n"
						+"Amount: "+ payment.getAmount()+"\n"
						+"Card_no: "+ payment.getCard_no()+"\n" 
						+"Security_code: "+ payment.getSecurity_code()+"\n" 
						+"Expiration_date: "+ payment.getExpiration_date() +"\n";
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return response;
		}
		
		// delete payment from the database
		public String detele(int id) {
			
			String sql = "DELETE FROM `electro_grid`.`payment` WHERE (`id` = ?);";
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
