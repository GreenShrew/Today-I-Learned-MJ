package ezen.student.service;

import java.util.ArrayList;

import ezen.student.dao.StudentDao;
import ezen.student.dto.Student;

public class SelectAllService {
	
	private StudentDao sdao;
	
	public SelectAllService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public ArrayList<Student> selectAllStudent(){
		ArrayList<Student> list = null;
		list = sdao.selectAllStudent();
		return list;
	}
}
