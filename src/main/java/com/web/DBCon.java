package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	
	private static final String URL = "jdbc:mariadb://database-1.cicmav94awml.ap-northeast-2.rds.amazonaws.com:3306/EZEN";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "!WLSpjy852";
	private static final String DRIVER_CLASS_ME = "org.mariadb.jdbc.Driver";
	
	private static void setDriverClassName() {
		try {
			Class.forName(DRIVER_CLASS_ME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		setDriverClassName();
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = getConnection();
		System.out.println(con);
	}
}
