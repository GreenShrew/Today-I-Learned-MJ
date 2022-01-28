package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentSelectOneService {

	private StudentDao sdao;
	
	StudentSelectOneService(StudentDao sdao){
		this.sdao = sdao;
	}
	
	public Student selectOneService(String snum) {
		Student std = sdao.selectOneService(snum);
		return std;
	}
}
