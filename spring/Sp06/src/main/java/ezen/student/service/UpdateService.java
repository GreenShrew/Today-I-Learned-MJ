package ezen.student.service;

import java.util.ArrayList;

import ezen.student.dao.StudentDao;
import ezen.student.dto.Student;

public class UpdateService {
	
	private StudentDao sdao;
	
	public UpdateService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void updateStudent(Student std){
		sdao.updateStudent(std);
	}
}
