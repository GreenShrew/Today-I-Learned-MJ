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
		        //mvo.setUseyn(rs.getString("useyn"));
		        //mvo.setIndate(rs.getTimestamp("indate"));
				return mvo;
			}
		}, id);  // ? 에 해당하는 값은 괄호가끝나기전 , 로 구분하여 명시해줍니다.
		// 물음표가 두개 이상이라면 역시 , 로 구분해서 순서데로 명시해줍니다

		if( list.size()==0) return null;
		else return list.get(0);
		// 한며의 멤버데이터를 리터받아야 하는 상황이라도, 결과를 리스트로 도출해서 첫번째값을 리턴합니다
	}

	public List<AddressVO> selectAddressByDong(String dong) {
		String sql = "select * from address where dong like '%'||?||'%' ";
		// 위 SQL 문은 검색어 ? 에 해당하는 단어가 있으면 그 단어를 포함하는 검색을하고, 없으면 모두검색의 효과를 얻을수 있습니다
		List<AddressVO> list = template.query( sql , new RowMapper<AddressVO>(){

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
		} , dong );
		return list;
	}

	public void insert(MemberVO mvo) {
		String sql = "insert into member( userid, name, pwd, zip_num, address, address2, email, phone)"
				+ " values( ? , ? , ? , ? , ? , ? , ? , ? )";
		template.update( sql , mvo.getUserid(), mvo.getName(), mvo.getPwd(), mvo.getZip_num(), 
				mvo.getAddress(), mvo.getAddress2(), mvo.getEmail(), mvo.getPhone() );		
	}

	public void update(MemberVO mvo) {
		String sql = "update member set pwd=? , name=? , zip_num=? , address=? , address2=? , "
				+ " email=? , phone=? where userid=?";
		template.update( sql, mvo.getPwd(), mvo.getName(), mvo.getZip_num(), mvo.getAddress(), 
				mvo.getAddress2(), mvo.getEmail(),  mvo.getPhone(), mvo.getUserid() );
	}

}

































