package com.electrogrid.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.electrogrid.dbcontext.DatabaseConnection;
import com.electrogrid.dbcontext.IDBContext;
import com.electrogrid.model.Salary;

public class SalaryRepository {
	
	
	private Connection connection = null;
	private IDBContext dbContext;
	private Statement statement;
	private ResultSet resultSet;
	private static PreparedStatement preparedStatement = null;
	
	public SalaryRepository() {
		super();
		this.dbContext = new DatabaseConnection();
		this.connection = dbContext.getDatabaseConnection();
		
	}
	
	//get all salary from the database
	public List<Salary> getSalary_s(){
		
		List<Salary> salary_s = new ArrayList<Salary>();
		String sql = "SELECT * FROM salary";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Salary salary = new Salary();
				salary.setId(resultSet.getInt(1));
				salary.setFull_name(resultSet.getString(2));
				salary.setNic(resultSet.getString(3));
				salary.setBirthday(resultSet.getString(4));
				salary.setAddress(resultSet.getString(5));
				salary.setMember_position(resultSet.getString(6));
				salary.setEmail(resultSet.getString(7));
				salary.setMonthly_sal(resultSet.getString(8));
				salary.setWorking_hours(resultSet.getString(9));
				salary.setMobile_no(resultSet.getString(10));
				salary.setDate(resultSet.getString(11));
				
				
				
				salary_s.add(salary);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return salary_s;
	}
	
	// get one salary from the database
	public List<Salary> getSalary(int id){
		
		List<Salary> salary_s = new ArrayList<Salary>();
		String sql = " SELECT * FROM `electro_grid`.`salary` WHERE (`id` = "+id+");";
		try {
			
			//PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, id);
	
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Salary salary = new Salary();		
				salary.setId(resultSet.getInt(1));
				salary.setFull_name(resultSet.getString(2));
				salary.setNic(resultSet.getString(3));
				salary.setBirthday(resultSet.getString(4));
				salary.setAddress(resultSet.getString(5));
				salary.setMember_position(resultSet.getString(6));
				salary.setWorking_hours(resultSet.getString(7));
				salary.setMobile_no(resultSet.getString(10));
				salary.setDate(resultSet.getString(11));
				
				
				salary_s.add(salary);
			}
			//preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return salary_s;
	}
	
	//get user by salary id
	public Salary getSalaryById(int id) {
		return null;
	}
	
	//add new salary for the data base
	public void addSalary(Salary salary) {
		String sql = "insert into user value (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,	salary.getId());
			preparedStatement.setString(2,salary.getFull_name());
			preparedStatement.setString(3,salary.getNic());
			preparedStatement.setString(4,salary.getBirthday());
			preparedStatement.setString(5,salary.getAddress());
			preparedStatement.setString(6,salary.getMember_position());
			preparedStatement.setString(7,salary.getEmail());
			preparedStatement.setString(8,salary.getMonthly_sal());
			preparedStatement.setString(9,salary.getWorking_hours());
			preparedStatement.setString(10,salary.getMobile_no());
			preparedStatement.setString(11,salary.getDate());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// update salary details
	public String updateSalary(Salary salary) {
		
		String sql = "UPDATE `electro_grid`.`salary` SET `full_name` = ?, `nic` = ?, `birthday` = ?, `address` = ?, `member_position` =? , `email` = ? , `monthly_sal` =? , `working_hours` =? , `mobile_no` =? , `date` =?  WHERE `id` = ?";
		String response = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.setString(1, salary.getFull_name());
			preparedStatement.setString(2, salary.getNic());
			preparedStatement.setString(3, salary.getBirthday());
			preparedStatement.setString(4, salary.getAddress());
			preparedStatement.setString(5, salary.getMember_position());
			preparedStatement.setString(6, salary.getEmail());
			preparedStatement.setString(7, salary.getMonthly_sal());
			preparedStatement.setString(8, salary.getWorking_hours());
			preparedStatement.setString(9, salary.getMobile_no());
			preparedStatement.setString(10, salary.getDate());
			preparedStatement.setInt(11, salary.getId());
			
			preparedStatement.executeUpdate();
			
			response = "successfuly update\n"
					+"ID: "+ salary.getId()+"\n"
					+"Full_name: "+ salary.getFull_name()+"\n"
					+"Nic: "+ salary.getNic()+"\n"
					+"Birthday: "+ salary.getBirthday()+"\n"
					+"Address: "+ salary.getAddress()+"\n" 
					+"Member_position: "+ salary.getMember_position()+"\n" 
					+"Email: "+ salary.getEmail() +"\n"
			        +"Monthly_sal: "+ salary.getMonthly_sal() +"\n"
			        +"Working_hours: "+ salary.getWorking_hours() +"\n"
			        +"Mobile_no: "+ salary.getMobile_no() +"\n"
			        +"Date: "+ salary.getDate() +"\n";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return response;
	}
	
	// delete salary from the database
	public String detele(int id) {
		
		String sql = "DELETE FROM `electro_grid`.`salary` WHERE (`id` = ?);";
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



