package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentUpdateService {
	
//	StudentDao sdao = new StudentDao();
	// 위의 방식으로 불러오지 않는다!
	// update를 하거나 뭘 하던간에 계속해서 이를 계속 불러오게 된다!
	// 사용자가 많아도 계속 생성하게 된다!
	
	StudentDao sdao;
	public StudentUpdateService(StudentDao sdao) {	// 생성자를 만든다.
		this.sdao = sdao;
	}
	// 그리고 SpringContainerClass 클래스에서 StudentUpdateService에 대한 인스턴스를 만들고
	// 이를 getter로 불러올 수 있도록 만든다.
	// 이렇게 하면 여러사람이나 여러 동작을 할 때 그 때마다 sdao를 불러오던 동작을
	// 하나의 sdao 인스턴스를 이용하여 코드를 만들 수 있다.
	
	public void updateStudent(Student std) {
		sdao.updateStudent(std);
	}
}
