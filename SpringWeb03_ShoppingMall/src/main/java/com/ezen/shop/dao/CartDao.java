package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.shop.dto.CartVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class CartDao {

	private JdbcTemplate template;
	
	@Autowired  
	public CartDao( ComboPooledDataSource dataSource ) {
		this.template = new JdbcTemplate(dataSource);
	}

	public void insert(CartVO cvo) {
		String sql = "insert into cart(cseq, userid, pseq, quantity) values(cart_seq.nextVal, ?, ?, ?)";
		template.update(sql, cvo.getUserid(), cvo.getPseq(), cvo.getQuantity());
	}

	public List<CartVO> listCart(String userid) {
		String sql = "select * from cart_view where userid=? and result='1'";
		List<CartVO> list = template.query(sql, new RowMapper<CartVO>() {

			@Override
			public CartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CartVO cvo = new CartVO();
				cvo.setCseq(rs.getInt(1));
				cvo.setUserid(rs.getString(2));
				cvo.setMname(rs.getString(3));
				cvo.setPseq(rs.getInt(4));
				cvo.setPname(rs.getString(5));
				cvo.setQuantity(rs.getInt(6));
				cvo.setPrice2(rs.getInt(7));
				cvo.setResult(rs.getString(8));
				cvo.setIndate(rs.getTimestamp(9));
				return cvo;
			}
			
		}, userid);
		
		return list;
	}

	public void delete(String cseq) {
		String sql = "delete * from cart where cseq=?";
		template.update(sql, cseq);
	}
	
	
}
