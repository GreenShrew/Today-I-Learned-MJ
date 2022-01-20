package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.ProductVO;
import com.ezenac.util.Dbman;

public class ProductDao {
	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ProductVO> getBestList() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		String sql = "select * from best_pro_view";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				// 베스트 상품의 이름, 가격, 이미지만 현재 필요하기 때문에 필요한 필드만 dto에 담는다.
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
		return list;
	}



	public ArrayList<ProductVO> getnewList() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		String sql = "select * from new_pro_view";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				// 신상품의 이름, 가격, 이미지만 현재 필요하기 때문에 필요한 필드만 dto에 담는다.
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
		return list;
	}



	public ProductVO getProduct(int pseq) {
		ProductVO pvo = new ProductVO();		// 어차피 null값은 넘어오지 않기 떄문이 일찌감치 객체를 생성한다.
		String sql = "select * from member where pseq=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("Bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return pvo;
	}
	
}
