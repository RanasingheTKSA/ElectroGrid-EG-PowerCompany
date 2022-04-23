package com.electrogrid.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.Power;
import com.electrogrid.model.User;
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
		String sql = "SELECT * FROM powers";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Power power = new Power();
				power.setId(resultSet.getString(1));
				power.setPower_connection_type(resultSet.getString(2));
				power.setPower_bill_id(resultSet.getString(3));
				power.setPower_used_units(resultSet.getString(4));
				power.setPower_unit_value(resultSet.getString(5));
				power.setPower_pay_value(resultSet.getString(6));
				power.setPower_pay_balance(resultSet.getString(7));
				power.setPower_bill_value(resultSet.getString(7));
				
				powers.add(power);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return powers;
	}
	
	
	
	
	
	//add new users for the data base
		public void addPower(Power power) {
			String sql = "insert into powers value (?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				//preparedStatement.setString(1,	user.getId());
				preparedStatement.setString(2,power.getPower_connection_type());
				preparedStatement.setString(3, power.getPower_bill_id());
				preparedStatement.setString(4, power.getPower_used_units());
				preparedStatement.setString(5, power.getPower_unit_value());
				preparedStatement.setString(6, power.getPower_pay_value());
				preparedStatement.setString(7, power.getPower_pay_balance());
				preparedStatement.setString(8, power.getPower_bill_value());
				
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("insert into powers statement fail");
			}
		}

	
}
