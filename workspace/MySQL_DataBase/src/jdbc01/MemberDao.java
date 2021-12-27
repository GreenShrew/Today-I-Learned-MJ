package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// MemberDao 클래스를 싱글톤으로 쓰기 위한 작업
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {
		return itc;
	}
	
	
	public ArrayList<MemberDto> selectAll(){	// 테이블 전체가 넘어가므로 ArrayList 사용
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "select num, name, phone, bpoint, age, gender, date_format(birth, '%Y-%m-%d') as bt, date_format(joindate, '%Y-%m-%d') as jd "
				+ "from memberlist order by num desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setNum(rs.getInt("num"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getString("bt"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setJoindate(rs.getString("jd"));
				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
		}
	
	public int insert(MemberDto mdto){
		int result =0;
		String sql = "insert into memberlist(name, phone, birth, gender, age) values(?, ?, str_to_date(concat('', ?, ''),'%Y-%m-%d'), ?, ?)";
		// concat('', ?, '') <- 작은 따옴표
		// concat을 사용한 이유 : 그냥 str_to_date(?, ....) 로 썼을 때 ?를 문자로 인식하지 못하는 경우가 생긴다. 이를 방지하기 위해 문자와 이어붙이기 연산을 시켜
		// 아예 문자라는것을 확실하게 하기 위해서이다.
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setString(4, mdto.getGender());
			pstmt.setInt(5, mdto.getAge());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
	
	public int update(MemberDto mdto){
		int result =0;
		String sql = "update memberlist set name=?, phone=?, birth=date_format(concat('', ? , ''), '%Y%m%d'), joindate=date_format(concat('', ? , ''), '%Y%m%d'), bpoint=?, gender=?, age=? where num=?";
		//(name, phone, birth, age, gender, bpoint)
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setString(4, mdto.getJoindate());
			pstmt.setInt(5, mdto.getBpoint());
			pstmt.setString(6, mdto.getGender());
			pstmt.setInt(7, mdto.getAge());
			pstmt.setInt(8, mdto.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
	
	public int delete(int num){
		int result =0;
		String sql = "delete from memberlist where num=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
	
	public MemberDto selectOne(int num){	// 하나의 데이터만 넘어가므로 MemberDto를 사용
		MemberDto mdto = null;
		String sql = "select num, name, phone, bpoint, age, gender, "
				+ " date_format(birth, '%Y-%m-%d') as bt, "
				+ " date_format(joindate, '%Y-%m-%d') as jd "
				+ " from memberlist where num = ? order by num desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setNum(rs.getInt("num"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getString("bt"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setJoindate(rs.getString("jd"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return mdto;
	}
	
}

/*	각 메소드에 공통으로 들어가는 파츠

String sql = "";
con = Dbman.getConnection();
try {
	pstmt = con.prepareStatement(sql);
	
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	Dbman.close(con, pstmt, rs);
}

*/