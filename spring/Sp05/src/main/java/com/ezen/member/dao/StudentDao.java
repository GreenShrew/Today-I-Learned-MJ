package com.ezen.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.member.dto.Student;

public class StudentDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pw = "tiger";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
		String sql = "insert into student(snum, sid, spw, sname, sage, sgender, smajor) values (?, ?, ?, ?, ?, ?, ?)";
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
		} finally {
			close();
		}
	}

	public ArrayList<Student> selectStudent() {
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
				);	// Student 클래스는 전달인자를 필요로 한다. 따라서 위와 같이 전달인자로 넣는것이다!
				list.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Student selectOneService(String snum) {
		Student std = null;
		String sql = "select * from student where sNum=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, snum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				std = new Student(
						rs.getString("sNum"),
						rs.getString("sId"),
						rs.getString("sPw"),
						rs.getString("sName"),
						rs.getInt("sAge"),
						rs.getString("sGender"),
						rs.getString("sMajor")
				);	// Student 클래스는 전달인자를 필요로 한다. 따라서 위와 같이 전달인자로 넣는것이다!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return std;
	}
}
