package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.AdminVO;
import com.ezenac.dto.ProductVO;
import com.ezenac.util.Dbman;
import com.ezenac.util.Paging;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminVO workerCheck(String workId) {
		AdminVO avo = null;
		String sql = "select * from worker where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avo = new AdminVO();
				avo.setId(rs.getString("id"));
				avo.setPwd(rs.getString("pwd"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return avo;
	}

	public ArrayList<ProductVO> listProduct(Paging paging) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
//		String sql = "select * from product order by pseq desc";
		// 기존에 썼던 핵심 sql문을 별칭 q로 설정하고, 이 sql문을 서브쿼리로 만든다.
		String sql = "select * from ("
				+ "select rownum as rn, p.* from ((select * from product order by pseq desc) p)"
				+ ") where rs>=?"
				+ ") where rn<=?";	
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) as cnt from product";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");		// 레코드의 갯수를 세고 그 값을 cnt라는 별칭으로 저장하고, 이를 count에 저장한다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;
	}
}
