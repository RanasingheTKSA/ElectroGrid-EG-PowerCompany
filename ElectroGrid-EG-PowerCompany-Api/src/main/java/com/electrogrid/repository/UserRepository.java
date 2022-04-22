package com.electrogrid.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.User;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;

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
				user.setId(resultSet.getString(1));
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
			//preparedStatement.setString(1,	user.getId());
			preparedStatement.setString(2,user.getUser_name());
			preparedStatement.setString(3, user.getUser_nic());
			preparedStatement.setString(4, user.getUser_address());
			preparedStatement.setString(5, user.getUser_zip_code());
			preparedStatement.setString(6, user.getUser_contact_number());
			preparedStatement.setString(7, user.getUser_email());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
}
