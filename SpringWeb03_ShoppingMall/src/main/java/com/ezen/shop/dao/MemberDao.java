package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.shop.dto.AddressVO;
import com.ezen.shop.dto.MemberVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class MemberDao {
	
	private JdbcTemplate template;
	@Autowired  
	public MemberDao( ComboPooledDataSource dataSource ) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	
	public MemberVO getMember(String id) {
		String sql = "Select * from member where userid=?";
		List<MemberVO> list = template.query(sql, new RowMapper<MemberVO>(){
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO mvo = new MemberVO();
				mvo.setUserid(rs.getString("userid"));
				mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setZip_num(rs.getString("zip_num"));
		        mvo.setAddress(rs.getString("address"));
		        mvo.setAddress2(rs.getString("address2"));
		        mvo.setPhone(rs.getString("phone"));
//		        mvo.setUseyn(rs.getString("useyn"));
//		        mvo.setIndate(rs.getTimestamp("indate"));
				return mvo;
			}
		}, id);	// ?에 해당하는 값은 괄호가 끝나기 전 , 콤마로 구분하여 명시해준다.
		// 물음표가 두개 이상이라면 역시 , 콤마로 구분하여 순서대로 명시해준다.
		// 이제 예전같이 pstmt.setInt(1,xxx); 뭐 이럴 필요가...없나?
		
		if( list.size()==0) return null;
		else return list.get(0);
		// 한명의 멤버 데이터를 리턴받아야 하는 상황이라도, 결과를 리스트로 도출해서 첫번째 값을 리턴한다.
	}
	
	
	public List<AddressVO> selectAddressByDong(String dong) {
		String sql = "select * from address where dong like '%'||?||'%'";
		// 위 sql문은 검색어 ? 에 해당하는 단어가 있으면 그 단어를 포함하는 주소를 검색한다.
		// ?에 단어가 없다면 전부 검색하는 효과를 얻는다.
		List<AddressVO> list = template.query(sql, new RowMapper<AddressVO>() {

			@Override
			public AddressVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				AddressVO avo = new AddressVO();
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setBunji(rs.getString("bunji"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setZip_num(rs.getString("zip_num"));
				return avo;
			}
		}, dong);
		return list;
	}


	public void insert(MemberVO mvo) {
		String sql = "insert into member(userid, name, pwd, zip_num, address, address2, email, phone) "
				+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
		// insert이므로 query가 아니라 update이다.
		// pstmt.setString(1, mvo.getUserid()) 이런식으로 안 써도 된다!
		template.update(sql, mvo.getUserid(), mvo.getName(), mvo.getPwd(), mvo.getZip_num(), mvo.getAddress(), 
				mvo.getAddress2(), mvo.getEmail(), mvo.getPhone());
	}


	public void update(MemberVO mvo) {
		String sql = "update member set pwd=?, name=?, zip_num=?, address=?, address2=?, "
				+ " email=?, phone=? where userid=?";
		template.update(sql, mvo.getPwd(), mvo.getName(), mvo.getZip_num(), mvo.getAddress(),
				mvo.getAddress2(), mvo.getEmail(), mvo.getPhone(), mvo.getUserid());
	}

}
