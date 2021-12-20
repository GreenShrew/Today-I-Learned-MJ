package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Insert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;	
		PreparedStatement pstmt = null;
		// insert 명령의 경우 결과값이 따로 없어서 ResultSet 은 사용하지 않는다.
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
//			System.out.println("연결성공");
			
			Scanner sc = new Scanner(System.in);
			
//			System.out.println("저장할 번호를 입력하세요 : ");
//			int num = Integer.parseInt(sc.nextLine());	<- 시퀀스로 대체한다.
			System.out.println("이름을 입력하세요 : ");	
			String name = sc.nextLine();	
			System.out.println("이메일을 입력하세요 : ");
			String email = sc.nextLine();	
			System.out.println("전화번호를 입력하세요 : ");
			String tel = sc.nextLine();
			
			// SQL에서의 insert 명령은 아래와 같다.
			// insert into customer values(6, '김하나', 'abc5@naver.com', 010-4567-7897')
			
//			String sql = "insert into customer values(6, '김하나', 'abc5@naver.com', 010-4567-7897')";
			// 이걸 넣는게 아니라 위 스캐너에서 넣는 내용을 써야한다!
			
			// String sql = "insert into customer values(" + num + ", '" + name + "', '" + email + "', '" + tel + "')";
			// + 이어붙이기로 변수와 텍스트를 나눈다!
			// 다만 위의 방법은 옛날 방식이다!
			
			String sql = "insert into customer values(num_seq.nextVal, ?, ?, ?)";
			// 이것이 요즘 방식! 확실하게 줄어들었다!
			
			// 먼저 sql 명령을 select 때와 같이 pstmt. 에 장착합니다.
			pstmt = con.prepareStatement(sql);
			
			// ? 의 순서에 맞춰서 입력값들을 셋팅한다. 괄호 안 숫자는 몇번째 ?에 연결되어있는지에 대한 숫자이다.
//			pstmt.setInt(1, num);	<- 시퀀스를 만들었으므로 이제부터 번호는 시퀀스로 입력한다.
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			
			// SQL select 명령만 excuteQuery를 사용하고,
			// 나머지(insert, delete, update)는 excuteUpdate 메소드를 사용한다.
			// excuteUpdate의 결과는 sql 명령이 정상 동작했을때 1, 실패했을때 0이 리턴된다.
			int result = pstmt.executeUpdate();
			
			// 아래는 저장여부 확인용.
			if(result==1) {
				System.out.println("레코드 추가 성공");
			}else {
				System.out.println("레코드 추가 실패");
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
