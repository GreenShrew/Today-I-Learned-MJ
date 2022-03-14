package com.ezen.spg09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	// 이제는 template도 간단하게 Autowired로 가져다 쓰면 된다.
	@Autowired
	private JdbcTemplate template;
	
	// 아래는 옛날 방식... Legacy Project에서 사용한 방법
	// 해당 클래스를 servlet-context.xml에 bean으로 넣어 놓아야하는 수고스러움이 있는 옛날 방식이다.
/*	UserDao(Datasource ....){
		template = new JdbcTemplate(DataSource);
	} */
	
	public List<UserDto> list() {
		
		String sql = "select * from myuser";
		
		List<UserDto> list = template.query(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));
		// ResultSet 사용없이 검색 결과 레코드의 필드를 Dto 변수에 넣고, list에 add 동작을 실행한다.
		// 결과 레코드 갯수 만큼 실행한다.
		
		return list;
	}

}
