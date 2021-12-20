package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;			// 연결을 위한 객체
		PreparedStatement pstmt = null;	// con에 SQL을 실행해주는 객체
		ResultSet rs = null;		// SQL 실행결과를 저장하는 객체
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
//			System.out.println("데이터베이스에 연결 성공하였습니다.");		// 제작 과정 중에 이 메시지를 넣고, 메세지 출력이 잘 된다면 주석처리 하는것도 하나의 개발 방법
			String sql = "select * from customer";
			// 데이터베이스 연결 후에는 SQL 명령을 사용하기 위해 String 변수에 SQL 명령을 준비한다.
			// 데이터베이스에 제공되어질 명령이므로 String 형으로 준비한다.
			
			// SQL 문을 장착한 con을 pstmt에 전달한다.
			pstmt = con.prepareStatement(sql);		// 공식으로 기억했다가 사용한다.
			// pstmt = con.prepareStatement("select * from customer");
			
			// pstmt에 sql을 장착하고 실행해서, 그 결과를 rs에 저장한다.
			rs = pstmt.executeQuery();
			// 여기까지 쓰면 DB의 Table을 읽어오게 된 것이다.
			
			System.out.println("번호 \t 이름  \t\t 이메일 \t\t\t 전화번호");
			System.out.println("--------------------------------------------------------------");
			
			// rs.next() : 최초 실행은 객체의 시작부분(데이터 없는 곳)에서 첫번째 레코드로 이동하는 메소드. 그 다음부터는 다음 레코드로 이동.
			// rs.next() 메소드가 실행될 때 다음 레코드가 있으면 true, 없으면 false를 리턴.
			
			while(rs.next()) {
				// 결과의 처음부터 끝까지 반복 실행 : 레코드 단위로 반복 실행
				// rs.getInt() : number형 필드값을 추출하는 메소드. 괄호안에 필드 이름을 정확히 써야한다. 문자형 자료는 getString()을 이용한다.
				// 필드명에 오타가 있거나 안 맞으면 '부적합한 열 이름' 이라는 에러가 발생한다.
				int num = rs.getInt("num");
				//rs.getString() : varchar2형 필드값을 추출하는 메소드
				// 모든 자료형에 대해 get~() 메소드가 모두 존재한다.
				String name = rs.getString("name");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				System.out.printf("%d \t %s \t %s \t %s \t\n",num,name,email,tel);
			}
			// 1. pstmt에 sql을 장착하고 실행해서, 그 결과를 rs 에 저장한다.
			// 2. 저장 결과를 하나씩 레코드별로 필드별로 하나씩 꺼내서 콘솔창에 출력한다.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
