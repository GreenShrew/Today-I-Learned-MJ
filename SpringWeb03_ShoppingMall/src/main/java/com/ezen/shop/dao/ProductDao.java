package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.shop.dto.ProductVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class ProductDao {

	// 데이터베이스에서 데이터의 삽입, 수정, 삭제, 조회(CRUD) 를 담당할 객체를 선언한다.
	private JdbcTemplate template;	// 이 안에 con, pstmt, rs가 모두 존재한다.
	/*
	// 스프링 컨테이너에 수동으로 넣어놓은 DBCP 클래스를 꺼내온다.
	@Autowired
	ComboPooledDataSource dataSource;
	
	// dataSource를 이용하여 수동으로 초기화를 해야하는 상황이므로,
	// 생성자 생성자에서 초기화한다.
	public ProductDao() {
		this.template = new JdbcTemplate(dataSource);
	}
	*/
	
	// 위의 작업을 조금 더 간단하게 만들 수 있다.
	// 생성자에서 한번에 쓴다.
	@Autowired
	public ProductDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public List<ProductVO> getNewList() {
		String sql = "select * from new_pro_view";
//		List<ProductVO> list => select 조회 결과는 list에 저장
//		templat.query(); => 템플릿을 이용한 테이블 조회, 결과는 List<ProductVO> list 형 리스트
//		List<ProductVO> list = template.query();

//		익명 클래스 변수이름 = new RowMapper<ProductVO>(){};		
		List<ProductVO> list = template.query(sql, new RowMapper<ProductVO>() {
			
			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage(rs.getString("Image"));
				return pvo;
			}
		});	// 익명 클래스! 생성자가 실행되며 바로 만들어지는 클래스!
		return list;
	}

	public List<ProductVO> getBestList() {
		// TODO Auto-generated method stub
		return null;
	}

}
