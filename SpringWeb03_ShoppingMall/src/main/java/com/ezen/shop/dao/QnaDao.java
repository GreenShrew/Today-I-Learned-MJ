package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class QnaDao {

	private JdbcTemplate template;
	
	@Autowired  
	public QnaDao( ComboPooledDataSource dataSource ) {
		this.template = new JdbcTemplate(dataSource);
	}

	public Object listQna(String userid) {
		String sql = "select * from qna where id=? order by qseq desc";
		List<QnaVO> list = template.quary(sql, new RowMapper<QnaVO>()){
			
			@Override
			public QnaVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				return qvo;
			}
		},userid);
		return list;
	}
	
}
