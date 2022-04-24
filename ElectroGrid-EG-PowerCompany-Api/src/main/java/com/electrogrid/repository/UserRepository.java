package com.electrogrid.repository;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.User;

public class UserRepository {
	
	private Connection connection = null;
	private IDBContext dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public UserRepository() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	//get all users from the database
	public List<User> getUsers(){
		
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = new User();		
				user.setId(resultSet.getInt(1));
				user.setUser_name(resultSet.getString(2));
				user.setUser_nic(resultSet.getString(3));
				user.setUser_address(resultSet.getString(4));
				user.setUser_zip_code(resultSet.getString(5));
				user.setUser_contact_number(resultSet.getString(6));
				user.setUser_email(resultSet.getString(7));
				
				users.add(user);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return users;
	}
	
	// get one user from the database
	public List<User> getUser(int id){
		
		List<User> users = new ArrayList<User>();
		String sql = " SELECT * FROM `electro_grid`.`user` WHERE (`id` = "+id+");";
		try {
			

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = new User();		
				user.setId(resultSet.getInt(1));
				user.setUser_name(resultSet.getString(2));
				user.setUser_nic(resultSet.getString(3));
				user.setUser_address(resultSet.getString(4));
				user.setUser_zip_code(resultSet.getString(5));
				user.setUser_contact_number(resultSet.getString(6));
				user.setUser_email(resultSet.getString(7));
				
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return users;
	}
	
	//add new users for the data base
	public void addUser(User user) {
		String sql = "insert into user value (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
						
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getUser_name());
			preparedStatement.setString(3, user.getUser_nic());
			preparedStatement.setString(4, user.getUser_address());
			preparedStatement.setString(5, user.getUser_zip_code());
			preparedStatement.setString(6, user.getUser_contact_number());
			preparedStatement.setString(7, user.getUser_email());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// update user details
	public String updateUser(User user) {
		
		String sql = "UPDATE `electro_grid`.`user` SET `name` = ?, `nic` = ?, `address` = ?, `zipcode` = ?, `contact number` =? , `email` = ? WHERE `id` = ?";
		String response = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.setString(1, user.getUser_name());
			preparedStatement.setString(2, user.getUser_nic());
			preparedStatement.setString(3, user.getUser_address());
			preparedStatement.setString(4, user.getUser_zip_code());
			preparedStatement.setString(5, user.getUser_contact_number());
			preparedStatement.setString(6, user.getUser_email());
			preparedStatement.setInt(7, user.getId());
			
			preparedStatement.executeUpdate();
			
			response = "successfuly update\n"
					+"ID: "+ user.getId()+"\n"
					+"User_name: "+ user.getUser_name()+"\n"
					+"getUser_nic: "+ user.getUser_nic()+"\n"
					+"User_address: "+ user.getUser_address()+"\n"
					+"User_zip_code: "+ user.getUser_zip_code()+"\n" 
					+"User_contact_number: "+ user.getUser_contact_number()+"\n" 
					+"getUser_email: "+ user.getUser_email() +"\n";
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return response;
	}

	// delete user from the database
	public String detele(int id) {
		
		String sql = "DELETE FROM `electro_grid`.`user` WHERE (`id` = ?);";
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

	
//	// delete user from the database
//	public String detele(int id) {
//		
//		String sql = "DELETE FROM `electro_grid`.`user` WHERE (`id` = ?);";
//		String response = null;
//		
//		try {
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, id);
//			statement.executeUpdate();
//			
//			response = "successfuly Deleted \n";
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return response;
//	}
	
	
}