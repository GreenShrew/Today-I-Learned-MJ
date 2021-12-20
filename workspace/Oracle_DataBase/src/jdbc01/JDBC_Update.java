package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Update {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;	
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
//			System.out.println("연결 성공");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("수정할 회원의 번호를 입력하세요 : ");
			String num = sc.nextLine();
			
			System.out.print("수정할 항목을 선택하세요. 1. 이메일 2. 전화번호");
			String input = sc.nextLine();
			
			String sql = "";	// if문을 사용해도 된다.
			switch(input) {
			case "1" :
				System.out.print("새로운 이메일을 입력하세요 : ");
				String email = sc.nextLine();
				sql = "update customer set email=? where num=?";
				pstmt = con.prepareStatement(sql);	// 이게 들어가야 setString, setInt를 할 수 있다.
				pstmt.setString(1, email);
				pstmt.setInt(2, Integer.parseInt(num));
				break;
			case "2" :
				System.out.print("새로운 전화번호를 입력하세요 : ");
				String tel = sc.nextLine();
				sql = "update customer set tel=? where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tel);
				pstmt.setInt(2, Integer.parseInt(num));
				break;
			}
			
			int result = pstmt.executeUpdate();	// 수정 성공 여부 확인용
			if(result == 1) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
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
