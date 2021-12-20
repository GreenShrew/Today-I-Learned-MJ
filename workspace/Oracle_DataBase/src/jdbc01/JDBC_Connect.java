package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect {

	public static void main(String[] args) {
		// 지금까지 사용했던 오라클의 접속 정보는 아래와 같다!
		// url : jdbc:oracle:thin:@localhost:1521:xe
		// driver : oracle.jdbc.OracleDriver
		// id : scott
		// password : tiger
		// 이 정보들이 JAVA를 통해 접속할때도 필요하다!
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		// JDBC를 통해 데이터 베이스와 연결하게 해주는 클래스 : Connection
		Connection con = null;
		
		try {
			// 데이터베이스 연결을 위해 드라이버를 설정한다. (외부와 연결하기 떄문에 외부와의 연결이 실패할 수 있다. 예외처리가 필요하다.)
			Class.forName(driver);
			// 연결 url 을 목적지로 id와 pw 를 이용하여 연결을 실제 시행한다.
			// 연결된 연결객체는 변수 con에 저장한다.
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결에 성공하였습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ojdbc6.jar 파일을 확인하세요.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결정보를 확인하세요.");
		}
		
		try {
			if(con != null) con.close();
			System.out.println("데이터베이스 종료.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결이 종료되지 않았습니다.");
		}
	}

}
