package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezenac.dto.MemberVO;
import com.ezenac.util.Dbman;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberVO getMember(String id) {
		MemberVO mvo = null;
		String sql = "select * from member where id=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// 한사람이니깐 if
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress(rs.getString("address"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setUseyn(rs.getString("useyn"));
				mvo.setIndate(rs.getTimestamp("indate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return mvo;
	}
	
	
}
