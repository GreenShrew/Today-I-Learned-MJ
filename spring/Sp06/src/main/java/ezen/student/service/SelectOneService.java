package ezen.student.service;

import ezen.student.dao.StudentDao;
import ezen.student.dto.Student;

public class SelectOneService {
	
private StudentDao sdao;
	
	public SelectOneService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public Student selectOneStudent(String sId) {
		Student std = null;
		std = sdao.selectOneStudent(sId);
		return std;
	}
}
