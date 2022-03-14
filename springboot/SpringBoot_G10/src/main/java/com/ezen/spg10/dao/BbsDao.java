package com.ezen.spg10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.spg10.BbsDto;

@Repository
public class BbsDao implements IBbsDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<BbsDto> list() {
		String sql = "select * from bbs";
		List<BbsDto> list = template.query(
				sql, new BeanPropertyRowMapper<BbsDto>(BbsDto.class)
		);
		return list;
	}

	@Override
	public int write(BbsDto bdto) {
		String sql = "insert into bbs values(bbs_seq.nextVal, ?, ?, ?)";
		int result = template.update(
				sql, bdto.getWriter(), bdto.getTitle(), bdto.getContent()
		);
		return 0;
	}

	@Override
	public int update(BbsDto bdto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BbsDto view(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
