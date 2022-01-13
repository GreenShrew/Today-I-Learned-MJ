package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.dto.ProductVO;
import com.ezen.util.Dbman;

public class ProductDao {
	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ProductVO> selectAll() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		String sql = "select * from bookproduct order by code desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	// DB에서 데이터를 받아서
			while(rs.next()) {	// 반복문으로 pvo에 차곡차곡 넣는다.
				ProductVO pvo = new ProductVO();
				pvo.setCode(rs.getInt("code"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setPictureurl(rs.getString("pictureurl"));
				pvo.setDescription(rs.getString("description"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public ProductVO getProduct(String code) {
		ProductVO pvo = null;
		String sql = "select * from bookproduct where code=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(code));		// code가 String으로 왔다.
			rs = pstmt.executeQuery();	// DB에서 데이터를 받아서
			if(rs.next()) {	// 데이터가 있다면 pvo에 담는다.
				pvo = new ProductVO();
				pvo.setCode(rs.getInt("code"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setPictureurl(rs.getString("pictureurl"));
				pvo.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return pvo;
	}
	
	
}
