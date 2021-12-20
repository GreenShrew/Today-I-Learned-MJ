package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book_Insert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		
		Connection con = null;	
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("제목을 입력하세요");
			String subject = sc.nextLine();
			System.out.print("제작년도을 입력하세요");
			String makeyear = sc.nextLine();
			System.out.print("가격을 입력하세요");
			String inprice = sc.nextLine();
			System.out.print("대여료를 입력하세요");
			String rentprice = sc.nextLine();
			System.out.print("등급을 입력하세요");
			String grade = sc.nextLine();
			
			String sql = "insert into booklist values(book_seq.nextVal, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setInt(2, Integer.parseInt(makeyear));
			pstmt.setInt(3, Integer.parseInt(inprice));
			pstmt.setInt(4, Integer.parseInt(rentprice));
			pstmt.setString(5, grade);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
