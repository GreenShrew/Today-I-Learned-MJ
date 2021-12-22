package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {

	// dao 를 외부에서 새로 만들어 사용하지 못하도록 싱글톤으로 제작
	private MemberDao(){}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		}
		return conn;
	}
	
	private void close() {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {	e.printStackTrace();	
		}
	}
	
	public ArrayList<MemberDto> select(){
		// 전체 멤버를 조회해서 멤버리스트를 리턴
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();	
		String sql = "select * from memberlist order by num desc";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while( rs.next() ) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum( rs.getInt("num") );
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirth( rs.getDate( "birth") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getDate("joindate") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );
				list.add( mdto );
			}	
		} catch (SQLException e) { e.printStackTrace();
		} finally { close();  }
		return list;
	}
	
	public int insert( MemberDto mdto ){ 
		// 1명의 자료를 전달받아서  테이블에 레코드로 추가
		int result = 0;
		String sql = "insert into memberlist( num, name, phone, birth, "
				+ "gender, age) values( member_seq.nextVal, ? , ? , ? , ? , ? )";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1,  mdto.getName() );
			pstmt.setString( 2,  mdto.getPhone() );
			pstmt.setDate( 3, mdto.getBirth() );
			pstmt.setString( 4, mdto.getGender() );
			pstmt.setInt( 5, mdto.getAge() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { close();
		}
		return result;
	}
	
	
	
	public MemberDto getMember( int num ){
		// 회원번호 하나를 전달받아서 해당 회원의 정보를  MemberDto 형태로 리턴
		MemberDto mdto = null;
		String sql = "select * from memberlist where num=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  num );
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mdto = new MemberDto();
				mdto.setMembernum( rs.getInt("num") );
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirth( rs.getDate("birth") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getDate("joindate") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { close(); }
		return mdto;
	}
	public int update( MemberDto mdto ){
		// 1명의 자료를 전달받아서  해당 레코드를 수정
		int result = 0;
		String sql = "update memberlist set name=?, phone=? , birth=?, "
				+ " gender=?, age=?, bpoint=?, joindate=?  where num=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,  mdto.getName() );
			pstmt.setString(2,  mdto.getPhone() );
			pstmt.setDate( 3, mdto.getBirth() );
			pstmt.setString( 4, mdto.getGender() );
			pstmt.setInt( 5, mdto.getAge() );
			pstmt.setInt( 6, mdto.getBpoint() );
			pstmt.setDate(7,  mdto.getJoindate() );
			pstmt.setInt( 8, mdto.getMembernum() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { 		close(); }
		return result;
	}
	
	public int delete( int num ){
		// 1명의 회원번호를 전달받아서  해당 회원의 레코드를 삭제
		int result = 0;
		String sql = "delete from memberlist where num=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt( 1, num);			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { 		close(); }
		return result;
	}
}


