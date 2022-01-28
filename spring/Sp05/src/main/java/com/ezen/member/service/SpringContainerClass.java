package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class SpringContainerClass {
	// 여기에 모든 클래스의 객체가 하나씩 담길것이다!
	private StudentDao sdao;
	private StudentSelectService ss;
	private StudentInsertService is;
	private StudentSelectOneService ssos;
	
	public SpringContainerClass(){	// new 인스턴스를 생성하는 생성자.
		sdao = new StudentDao();
		ss = new StudentSelectService(sdao);
		is = new StudentInsertService(sdao);
		ssos = new StudentSelectOneService(sdao);
	}
	
	public StudentSelectService getSs() {		// 보관된 객체를 리턴해주는 getter 메소드	getBean 역할
		return ss;
	}

	public StudentInsertService getIs() {		// 보관된 객체를 리턴해주는 getter 메소드	getBean 역할
		return is;
	}

	public StudentSelectOneService getSsos() {
		return ssos;
	}
	
}
