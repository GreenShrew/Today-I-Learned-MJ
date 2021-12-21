package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	
	// dao를 외부에서 새로 만들어서 사용할 수 없도록 싱글톤으로 제작한다.
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }	// getInstance로만 이 클래스의 객체를 사용할 수 있다.
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.OracleDriver";
	Connection con = null;	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// getConnection과 close를 private로 쓴 이유는 어차피 이 안에서만 사용할 예정이기 때문이다.
	private Connection getConnection() {		// 아래 다섯 메소드에 각각 DB에 연결하는 try~catch 구문을 쓰지 않고 이 메소드로 묶었다.
		Connection conn = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void close() {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDto> select(){
		// 전체 멤버를 조회해서 멤버리스트를 리턴
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con = getConnection();
		try {
			String sql = "select * from memberlist order by num desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("num"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("brith"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setJoindate(rs.getDate("joindate"));
				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	
	public int insert(MemberDto mdto){
		// 한 명의 자료를 전달받아서 테이블에 레코드로 추가
		int result = 0;
		con = getConnection();
		String sql = "insert into memberlist(num, name, phone, birth, gender, age) values(member_seq.Val, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setDate(3, mdto.getBirth());
			pstmt.setString(4, mdto.getGender());
			pstmt.setInt(5, mdto.getAge());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return result;
	}
	
	public MemberDto getMember(int num){
		// 회원번호 하나를 전달받아서 해당 회원의 정보를 MemberDto 형태로 리턴
		MemberDto mdto = null;
		con = getConnection();

		String sql = "select * from memberlist where num=?";
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdto.setMembernum(rs.getInt("num"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("brith"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setJoindate(rs.getDate("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return mdto;
	}
	
	public int update(MemberDto mdto){
		// 한 명의 자료를 전달받아서 해당 레코드를 수정
		int result = 0;
		con = getConnection();

		close();
		return result;
	}
	
	public int delete(int num){
		// 한 명의 회원번호를 정달받아서 해당 회원의 레코드를 삭제
		int result = 0;
		con = getConnection();

		close();
		return result;
	}
}
