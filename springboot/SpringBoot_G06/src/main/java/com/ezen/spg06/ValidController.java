package com.ezen.spg06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {

	@RequestMapping("/")
    public String main() {
    	return "startPage";       
    }
	
	@RequestMapping("/create")
	public String create( @ModelAttribute("dto") ContentDto contentdto, 
			Model model , BindingResult result) {
		// 매개변수에 Dto 객체를 변수로 넣으면 전달되어 지는 파라미터들이 객체내의 동일한 이름의
		// 멤버변수에 자동 대입됩니다.// wirter -> contentdto.writer     content -> contentdto.content 
		// 아래는 옛날 방식
		// @RequstParam("writer") String writer, 
		// @RequstParam("content") String content, 
		// String writer = request.getParameter("writer");
		// String content = request.getParameter("content");
		
		// 매개변수 객체(매개변수) 앞에 ModelAttribute(전달이름)을 붙여서 return 되는 페이지에 해당 객체가 
		// model.addAttribute  로 넣은것처럼 같이 전달되게 합니다. 
		// model.addAttribute("dto" , contentdto );   와 동일한 동작
		
		
		// validation 기능이 있는 클래스를 만들어서 사용합니다
		ContentValidator validator = new ContentValidator();
		validator.validate( contentdto,  result);
		//BindingResult 	result  : 에러 제목(키값)과 내용(밸류값)을 담을 수 있는 객체
		// validator 의 멤버메서드인 validate 가  contentdto 내용을 검사한 후 result에 오류 내용을 담아주고, 
		// 리턴되지 않아도 call by reference  이기때문에 오류내용을 현재 위치에서도 result  라는 이름으로
		// 사용이 가능합니다.
		
		if( result.hasErrors() ) {
		// if( contentdto.getWriter().equals("") || contentdto.getContent().contentEquals("") ) {
			model.addAttribute("message" , "writer와 content는 비어있으면 안됩니다");
			return "startPage";
		}else
			return "DonePage";
		
	}
			
}
