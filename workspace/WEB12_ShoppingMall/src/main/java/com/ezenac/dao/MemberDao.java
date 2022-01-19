package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.AddressVO;
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

	public ArrayList<AddressVO> selectAddress(String dong) {	// 주소 검색기능
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		String sql = "select * from address where dong like '%'||?||'%'";	// ?가 문자, 숫자 둘 다 들어간다.
		// 문자를 넣어야한다는 의미로 || 를 이용해서 이어붙이기 연산을 시킨다. 그러면 이에 의해 String이 된다!
		// 위에서 ?가 null이면 조건이 없는것과 같은 검색 결과를 얻는다.
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public int insertMember(MemberVO mvo) {
		int result = 0;
		String sql = "insert into member(id, pwd, name, zip_num, address, email, phone) "
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getZip_num());
			pstmt.setString(5, mvo.getAddress());
			pstmt.setString(6, mvo.getEmail());
			pstmt.setString(7, mvo.getPhone());
			result = pstmt.executeUpdate();		// DB에 데이터가 잘 들어가면 1, 아니면 0이 return된다.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
	
	
}
