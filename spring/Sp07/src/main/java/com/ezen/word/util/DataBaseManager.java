package com.ezen.word.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

	private String driver;
	private String url;
	private String id;
	private String pw;
	
	private DataBaseUserinfo dbi;
	
	public DataBaseManager(DataBaseUserinfo dbi) {
		this.dbi = dbi;
	}
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbi.getDriver());
			con = DriverManager.getConnection(dbi.getUrl(), dbi.getId(), dbi.getPw());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
