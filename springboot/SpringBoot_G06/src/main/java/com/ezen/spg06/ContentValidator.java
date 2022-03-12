package com.ezen.spg06;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	} // 얘는 거의 사용하지 않습니다.
	

	@Override
	public void validate(Object target, Errors errors) {
		// Object target : 검사할 객체를 받아주는 메개변수(Object 형)
		// Errors errors : 보내온 객체에 에러내용을 담아서 다시 보내줄 매게변수
		
		ContentDto dto = (ContentDto)target;
		String sWriter = dto.getWriter();
		String sContent = dto.getContent();
		
		// 널(new String() 조차도 실행안된거)이거나  값이 비어있거나("")
		if(sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty");
			errors.rejectValue("writer", "trouble");
		}
				
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content", "trouble");
		}
	}

}




