package com.ezen.springmvc;

import org.springframework.stereotype.Repository;

// 만들어진 클래스를 스프링 컨테이너(스프링 프레임워크에서 제공)에 넣으려면 어노테이션 @Repository 를 사용한다.
@Repository
public class HomeDao {

	public String getMessage() {
		return "Dao에서 안녕하세요~ 라고 인사합니다.";
	}

}
