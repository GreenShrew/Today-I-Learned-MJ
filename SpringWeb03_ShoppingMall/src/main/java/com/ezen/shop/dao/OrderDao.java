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
public class OrderDao {

	private JdbcTemplate template;
	
	@Autowired  
	public OrderDao( ComboPooledDataSource dataSource ) {
		this.template = new JdbcTemplate(dataSource);
	}

	public void insertOrders(String userid) {
		String sql = "insert into order()";
		template.update(sql, );
	}

	public int lookupMaxOseq() {
		String sql = "select max(oseq) as moseq from orders";
		List<Integer> list = template.query(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int maxoseq = rs.getInt("moseq");
				return maxoseq;
			}});
		return list.get(0);
	}

	public void insertOrderDetail(CartVO cvo, int oseq) {
		String sql = "insert into order_detail() values()";
		template.update(sql, );
	}

	public void deleteCart(Integer cseq) {
		String sql = "delete * from cart where cseq=?";
		template.update(sql, cseq);
	}

}
