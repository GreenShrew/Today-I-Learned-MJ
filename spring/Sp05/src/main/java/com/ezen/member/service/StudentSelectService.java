package com.ezen.member.service;

import java.util.ArrayList;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentSelectService {
//	private StudentDao sdao = new StudentDao();

	private StudentDao sdao;
	StudentSelectService(StudentDao sdao){
		this.sdao = sdao;
	}
	
	public ArrayList<Student> selectStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		list = sdao.selectStudent();
		return list;
	}
	
	
}
