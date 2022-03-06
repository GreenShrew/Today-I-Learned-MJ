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

	// 데이터베이스에서 데이터의 삽입, 수정, 삭제, 조회 (CRUD) 를 담당할 객체를 선언합니다
	private JdbcTemplate template;  // 이안에  con, pstmt, rs  가 모두 존재합니다
	
	/*
	// 스프링 컨테이너에 수동으로 넣어놓은  DBCP 연결 인스턴스를 꺼내옵니다.
	@Autowired
	ComboPooledDataSource dataSource;	
	
	// dataSource 를 이용하여,  template 객체를 수동으로 초기화를 해야하는 상황이므로,
	// 생성자 생성자에서 초기화합니다
	public ProductDao() {
		this.template = new JdbcTemplate(dataSource);
	}
	*/
	
	@Autowired   // Autowired 로 빈을 꺼내와서 담는 동작은 생성자의 전달인수에도 가능합니다
	public ProductDao( ComboPooledDataSource dataSource ) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	
	public List<ProductVO> getNewList() {
		String sql = "select * from new_pro_view";
		// List<ProductVO> list =  => select 조회결과는  list 에 저장
		// templat.query();  => 템플릿을 이용한 테이블 조회, 결과는 List<ProductVO>형 리스트
		// List<ProductVO> list = template.query();
		// 익명 클래스 변수이름 = new RowMapper<ProductVO>(){};
		List<ProductVO> list = template.query(sql, new RowMapper<ProductVO>(){

			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ProductVO pvo = new ProductVO();
				pvo.setPseq( rs.getInt("pseq") );
				pvo.setName(rs.getString("name"));
    	    	pvo.setPrice2(rs.getInt("price2"));
    	    	pvo.setImage(rs.getString("image"));
				
    	    	return pvo;
			}
		});
		return list;
	}

	
	
	
	
	public List<ProductVO> getBestList() {
		String sql = "select * from best_pro_view";
		List<ProductVO> list = template.query( sql, new RowMapper<ProductVO>() {

			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();
				pvo.setPseq( rs.getInt("pseq") );
				pvo.setName(rs.getString("name"));
    	    	pvo.setPrice2(rs.getInt("price2"));
    	    	pvo.setImage(rs.getString("image"));
				return pvo;
			}
			
		});
		return list;
	}

}