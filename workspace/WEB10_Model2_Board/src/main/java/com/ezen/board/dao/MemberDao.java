package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.util.Dbman;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }
	
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDto getMember(String userid) {
		MemberDto mdto = null;
		String sql = "select * from member where userid=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userid);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mdto = new MemberDto();
				mdto.setUserid( rs.getString("userid") );
				mdto.setName( rs.getString("name") );
				mdto.setPwd( rs.getString("pwd") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setEmail( rs.getString("email") );
				mdto.setAdmin( rs.getInt("admin") );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);		}
		return mdto;
	}

	public int insertMember(MemberDto mdto) {
		int result = 0;
		String sql = "insert into member(userid, pwd, name, phone, email, admin) values(?, ?, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getPwd());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getEmail());
			pstmt.setInt(6, mdto.getAdmin());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}

	public void editMember(MemberDto mdto) {
		String sql = "Update member set pwd=?, name=?, phone=?, email=?, admin=? where userid=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getPwd());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getPhone());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setInt(5, mdto.getAdmin());
			pstmt.setString(6, mdto.getUserid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
	
}
