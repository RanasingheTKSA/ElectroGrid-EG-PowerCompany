package com.electrogrid.dbcontext;

import java.sql.Connection;

public interface IDBContext {
	
	public Connection getDatabaseConnection();
}
