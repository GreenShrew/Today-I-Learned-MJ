package com.mboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbman {

	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConnection(){	
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
		} catch (ClassNotFoundException e) {	e.printStackTrace();
		} catch (SQLException e) {	e.printStackTrace();	}
		return con;
	}
	public static void close(Connection con, PreparedStatement pstmt,
			ResultSet rs){
		try {
			if( con!=null)con.close();
			if( pstmt!=null) pstmt.close();
			if( rs!=null) rs.close();
		} catch (SQLException e) {e.printStackTrace();}	
	}
}
