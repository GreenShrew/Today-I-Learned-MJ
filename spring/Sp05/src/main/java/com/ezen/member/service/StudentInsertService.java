package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentInsertService {

	private StudentDao sdao;
	//	private StudentDao sdao = new StudentDao();
	StudentInsertService(StudentDao sdao){
		this.sdao = sdao;
	}
	
	public void insertStudent(Student std) {
		sdao.insertStudent(std);
	}
}
