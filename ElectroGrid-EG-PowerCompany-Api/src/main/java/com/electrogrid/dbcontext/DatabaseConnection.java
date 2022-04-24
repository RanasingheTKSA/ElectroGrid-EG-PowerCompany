package com.electrogrid.dbcontext;
 
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection implements IDBContext {

	private Connection dbContextConnection;
	private final String dbContextDriverName;
	private String dbContextConnectionString;
	private String dbContextUser;
	private String dbContextPassword;
	
	public DatabaseConnection() {
		this.dbContextDriverName = "com.mysql.jdbc.Driver";
		this.dbContextConnectionString = "jdbc:mysql://localhost:3306/electro_grid";
		this.dbContextUser = "root";
		this.dbContextPassword = "root";
		
	}
	
	@Override
	public Connection getDatabaseConnection() {
		try {
			Class.forName(dbContextDriverName);
			dbContextConnection = DriverManager.getConnection(dbContextConnectionString, dbContextUser, dbContextPassword);
			
			System.out.println("Database Connection Established");
			
		} catch (Exception e) {
			System.out.println("dbConnectionError: " + e.getMessage());
		}
		return dbContextConnection;
	}
	
}
