package com.opensso.security.services.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.opensso.security.services.DatabaseService;
import com.opensso.tutorial.BorderPage;





public class DatabaseServiceImpl extends BorderPage implements DatabaseService {

	private DataSource dataSource;
	
	private Connection con; 
	private Logger logger = getLogger(getClass()); 
	
	public Connection getConnection() {
		try {
			this.con = getDataSource().getConnection();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return con;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void destroy() {
		logger.info("Destroying Connection for permission service");
		try {
			this.con.close();
		} catch (Exception e) {
			logger.warn("Failed to close connection pool", e);
		}
	}
	
}
