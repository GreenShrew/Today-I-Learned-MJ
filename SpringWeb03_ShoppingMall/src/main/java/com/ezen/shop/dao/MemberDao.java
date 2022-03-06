package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
		String sql = "Select * from member where id=?";
		List<MemberVO> list = null;
		list = template.query(sql, new RowMapper<MemberVO>(){
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setZip_num(rs.getString("zip_num"));
		        mvo.setAddress(rs.getString("address"));
		        mvo.setPhone(rs.getString("phone"));
		        mvo.setUseyn(rs.getString("useyn"));
		        mvo.setIndate(rs.getTimestamp("indate"));
				return mvo;
			}
		}, id);
		if( list.size()==0) return null;
		else return list.get(0);
	}

}
