package ezen.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ezen.student.dto.DataBaseConnectionInfo;
import ezen.student.dto.Student;

public class StudentDao {
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String id = "scott";
//	String pw = "tiger";
	String driver = null;
	String url = null;
	String id = null;
	String pw = null;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 아래와 같이 써도 되지만, driver, rul, id, pw의 정보를 전부 담고 있는 객체 하나를 만드는게 더 좋다.
//	public StudentDao(String driver, String url, String id, String pw) {
//		this.driver = driver;
//		this.url = url;
//		this.id = id;
//		this.pw = pw;
//	}
	
	public StudentDao(DataBaseConnectionInfo dbconinfo) {	// 의존주입을 시킨다.
		this.driver = dbconinfo.getDriver();
		this.url = dbconinfo.getUrl();
		this.id = dbconinfo.getId();
		this.pw = dbconinfo.getPw();
	}
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	public void insertStudent(Student std) {
		String sql = "insert into student(snum, sid, spw, sname, sage, sgender, smajor) values(?, ?, ?, ?, ?, ?, ?)";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsNum());
			pstmt.setString(2, std.getsId());
			pstmt.setString(3, std.getsPw());
			pstmt.setString(4, std.getsName());
			pstmt.setInt(5, std.getsAge());
			pstmt.setString(6, std.getsGender());
			pstmt.setString(7, std.getsMajor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public ArrayList<Student> selectAllStudent(){
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student std = new Student(
						rs.getString("sNum"),
						rs.getString("sId"),
						rs.getString("sPw"),
						rs.getString("sName"),
						rs.getInt("sAge"),
						rs.getString("sGender"),
						rs.getString("sMajor")
				);
				list.add(std);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	public Student selectOneStudent(String sId) {
		Student std = null;
		String sql = "select * from student where sid=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				std = new Student(
						rs.getString("sNum"),
						rs.getString("sId"),
						rs.getString("sPw"),
						rs.getString("sName"),
						rs.getInt("sAge"),
						rs.getString("sGender"),
						rs.getString("sMajor")
				);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return std;
	}

	public void updateStudent(Student std) {
		String sql = "update student set sPw=?, sName=?, sAge=?, sGender=?, sMajor=? where sId=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsPw());
			pstmt.setString(2, std.getsName());
			pstmt.setInt(3, std.getsAge());
			pstmt.setString(4, std.getsGender());
			pstmt.setString(5, std.getsMajor());
			pstmt.setString(6, std.getsId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
