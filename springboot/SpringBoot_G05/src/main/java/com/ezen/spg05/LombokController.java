package com.ezen.spg05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LombokController {

	@RequestMapping("/")
    public String root() throws Exception{
        return "testForm";
    }
	
	@RequestMapping("/test1")
	public String test1( Member member, Model model) {
		// ModelAttribute 어노테이션을 사용하지 않아도, 모델에 저장되는 이름 member 라는 
		// 이름으로 유지되어 모델에 저장됩니다. 이때 객체의 이름을 반드시  클래스이름의 소문자로 정확히
		// 써줘야 합니다.   변수이름  member(O)   mem(X)   mbr(X)
		
		System.out.println(member.getId() + " " + member.getName() );
		
		return "test1";   
	}
}
