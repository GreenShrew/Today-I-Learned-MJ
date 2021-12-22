package jdbc05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBmanager {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String id = "scott";
	static String pw = "tiger";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) { 	e.printStackTrace();
		} catch (SQLException e) { 	e.printStackTrace();		}
		return conn;
	}
	
	public static void close( Connection con, PreparedStatement pstmt, ResultSet rs ) {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {  e.printStackTrace();
			}
	}
}
