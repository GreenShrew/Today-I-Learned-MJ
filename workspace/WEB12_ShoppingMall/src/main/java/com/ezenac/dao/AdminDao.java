package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.AdminVO;
import com.ezenac.dto.OrderVO;
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

	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
//		String sql = "select * from product order by pseq desc";
		// 기존에 썼던 핵심 sql문을 별칭 q로 설정하고, 이 sql문을 서브쿼리로 만든다.
		String sql = "select * from ("
				+ " select * from ("
				+ " select rownum as rn, p.* from "
				+ " ((select * from product where name like '%'||?||'%' order by pseq desc) p)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";	
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
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

	public int getAllCount(String tablename, String fieldname, String key) {
		int count = 0;
		String sql = "select count(*) as cnt from " + tablename + " where " + fieldname + " like '%'||?||'%'";
//		매개변수가 product, name, 바보 라면
//		select count(*) as cnt from product where name like '%'||바보||'%'";
//		가 된다!
//		위의 명령을 수행하면 product 테이블에서 name에 '바보' 라는 글자가 포함된 결과물을 긁어오고,
//		아래 cnt에는 그 결과물의 갯수를 저장하게 된다.
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
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

	public void insertProduct(ProductVO pvo) {
		String sql = "insert into product(pseq, kind, name, price1, price2, price3, content, image) "
				+ " values(product_seq.nextVal, ?, ?, ?, ?, ?, ? ,?)";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "update product set kind=?, useyn=?, name=?, price1=?, price2=?, price3=?, "
				+ " content=?, image=?, bestyn=?, where pseq=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getUseyn());
			pstmt.setString(3, pvo.getName());
			pstmt.setInt(4, pvo.getPrice1());
			pstmt.setInt(5, pvo.getPrice2());
			pstmt.setInt(6, pvo.getPrice3());
			pstmt.setString(7, pvo.getContent());
			pstmt.setString(8, pvo.getImage());
			pstmt.setString(9, pvo.getBestyn());
			pstmt.setInt(10, pvo.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public ArrayList<OrderVO> listOrder(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		String sql = "select * from order_view order by result, odseq desc) p)"; 이게 원본
		String sql = "select * from ("
				+ " select * from ("
				+ " select rownum as rn, m.* from "
				+ " ((select * from order_view where mname like '%'||?||'%' order by result, odseq desc) m)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// 리스트의 내용을 소진할때까지
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setId(rs.getString("id"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setMname(rs.getString("mname"));
				ovo.setZip_num(rs.getString("zip_num"));
				ovo.setAddress(rs.getString("address"));
				ovo.setPhone(rs.getString("phone"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setPname(rs.getString("pname"));
				ovo.setPrice2(rs.getInt("price2"));
				ovo.setResult(rs.getString("result"));
				list.add(ovo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
}
