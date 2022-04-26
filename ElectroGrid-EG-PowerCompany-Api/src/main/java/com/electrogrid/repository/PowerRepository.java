package com.electrogrid.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.Power;
//import com.electrogrid.model.User;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;


public class PowerRepository {
	private Connection connection = null;
	private IDBContext dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public PowerRepository() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	
	
	
	
	//get all powers acc from the database
	public List<Power> getPowers(){
		
		List<Power> powers = new ArrayList<Power>();
		String sql = "SELECT * FROM power";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Power power = new Power();
				power.setId(resultSet.getInt(1));
				power.setPower_connection_type(resultSet.getString(2));
				power.setPower_bill_id(resultSet.getString(3));
				power.setPower_used_units(resultSet.getString(4));
				power.setPower_unit_value(resultSet.getString(5));
				power.setPower_pay_value(resultSet.getString(6));
				power.setPower_pay_balance(resultSet.getString(7));
				power.setPower_bill_value(resultSet.getString(8));
				
				powers.add(power);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return powers;
	}
	
	
	// get one user from the database
		public List<Power> getPower(int id){
			
			List<Power> powers = new ArrayList<Power>();
			String sql = " SELECT * FROM `electro_grid`.`power` WHERE (`id` = "+id+");";
			try {
				
				//PreparedStatement preparedStatement = connection.prepareStatement(sql);
				//preparedStatement.setInt(1, id);
		
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Power power = new Power();		
					power.setId(resultSet.getInt(1));
					power.setPower_connection_type(resultSet.getString(2));
					power.setPower_bill_id(resultSet.getString(3));
					power.setPower_used_units(resultSet.getString(4));
					power.setPower_unit_value(resultSet.getString(5));
					power.setPower_pay_value(resultSet.getString(6));
					power.setPower_pay_balance(resultSet.getString(7));
					power.setPower_bill_value(resultSet.getString(8));
					
					powers.add(power);
				}
				//preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return powers;
		}
	
	
	//add new users for the data base
		public void addPower(Power power) {
//			String sql = "insert into powers value (?,?,?,?,?,?,?,?)";
			String sql = "INSERT INTO `electro_grid`.`power` (`id`, `power_connection_type`, `power_bill_id`, `power_used_units`, `power_unit_value`, `power_pay_value`, `power_pay_balance`, `power_bill_value`)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, power.getId());
				preparedStatement.setString(2,power.getPower_connection_type());
				preparedStatement.setString(3, power.getPower_bill_id());
				preparedStatement.setString(4, power.getPower_used_units());
				preparedStatement.setString(5, power.getPower_unit_value());
				preparedStatement.setString(6, power.getPower_pay_value());
				preparedStatement.setString(7, power.getPower_pay_balance());
				preparedStatement.setString(8, power.getPower_bill_value());
				
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println("error");
				System.out.println(e);
			}
		}

	
		
		
		
		// update user details
		public String updatePower(Power power) {
			
			//String sql = "UPDATE `electro_grid`.`powers` SET `power_connection_type` = ?, `power_bill_id` = ?, `power_used_units` = ?, `power_unit_value` = ?, `power_pay_value` =? , `power_bill_value` = ? , `power_pay_balance` =?, WHERE `id` = ?";
			//String sql = "UPDATE `electro_grid`.`powers` SET `power_connection_type` = ?, `power_bill_id` = ?, `power_used_units` = ?, `power_unit_value` = ?, "
					//+ "`power_pay_value` =? , `power_bill_value` = ?, `power_pay_balance` =?,WHERE `id` = ?";
			
			String sql = "UPDATE `electro_grid`.`power` SET `power_connection_type` = ?, `power_bill_id` = ?, `power_used_units` = ?, `power_unit_value` = ?, `power_pay_value` = ?, `power_pay_balance` = ?, `power_bill_value` = ? WHERE (`id` = ?)";

			String response = null;
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql); 
				preparedStatement.setString(1, power.getPower_connection_type());
				preparedStatement.setString(2, power.getPower_bill_id());
				preparedStatement.setString(3, power.getPower_used_units());
				preparedStatement.setString(4, power.getPower_unit_value());
				preparedStatement.setString(5, power.getPower_pay_value());
				preparedStatement.setString(6, power.getPower_pay_balance());
				preparedStatement.setString(7, power.getPower_bill_value());	
				preparedStatement.setInt(8, power.getId());
				
				preparedStatement.executeUpdate();
				
				response = "successfuly update\n"
						+"ID: "+ power.getId()+"\n"
						+"Power_connection_type: "+ power.getPower_connection_type()+"\n"
						+"Power_bill_id: "+ power.getPower_bill_id()+"\n"
						+"Power_used_units: "+ power.getPower_used_units()+"\n"
						+"Power_unit_value: "+ power.getPower_unit_value()+"\n" 
						+"Power_pay_value: "+ power.getPower_pay_value()+"\n" 
						+"Power_pay_balance: "+ power.getPower_pay_balance() +"\n"
						+"Power_bill_value: "+ power.getPower_bill_value() +"\n";
				
				
			} catch (Exception e) {
				System.out.println("err");
				System.out.println(e);
			}
			
			return response;
		}
		
		
		
		// delete user from the database
		public String detele(int id) {
			
			//String sql = "DELETE FROM `electro_grid`.`powers` WHERE (`id` = ?);";
			
			String sql = "DELETE FROM `electro_grid`.`power` WHERE (`id` = ?)";
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
