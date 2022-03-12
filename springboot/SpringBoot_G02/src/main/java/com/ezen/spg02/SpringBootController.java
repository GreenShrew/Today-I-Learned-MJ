package com.ezen.spg02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringBootController {

	@RequestMapping("/")
	public @ResponseBody String root() {
		
		return "JSP in Gradle~!!";
		// 함수 이름에 @ResponseBody 가 있으면 리턴되는 문자열이 웹 브라우져에 직접 쓰여지게 됩니다
	}
	
	@RequestMapping("/test1")     // localhost:8070/test1
	public String test1() {
        return "main";
	}
	
	
	@RequestMapping("/test2")   
	public String test2() {
        return "sub/sub";
	}
}
