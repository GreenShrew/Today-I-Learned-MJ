package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbman {
	private static String driver = "com.mysql.cj.jdbc.Driver";		// 어차피 외부에서 쓸 일 없으니 private static 로 만들었다.
	private static String url = "jdbc:mysql://localhost:3306/scott";
	private static String id = "root";
	private static String pw = "adminuser";
	
	public static Connection getConnection() {		// 이 메소드를 불러오면 DB에 연결해준다.
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {		// 이 메소드를 불러오면 연결된 DB의 연결을 끊는다.
			try {
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
