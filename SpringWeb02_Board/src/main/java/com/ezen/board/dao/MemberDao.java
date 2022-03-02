package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.util.DataBaseManager;

@Repository
public class MemberDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//	DataBaseManager dbm = new DataBaseManager();
	@Autowired
	DataBaseManager dbm;
	
	public MemberDto getMember(String id) {
		MemberDto mdto = null;
		con = dbm.getConnection();
		String sql = "select * from member where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setUserid(id);
				mdto.setPw(rs.getString("pwd"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.close(con, pstmt, rs);
		}
		return mdto;
	}

}
