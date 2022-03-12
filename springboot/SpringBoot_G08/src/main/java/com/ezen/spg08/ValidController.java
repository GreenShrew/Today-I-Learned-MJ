package com.ezen.spg08;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {

	@RequestMapping("/")
	 public String root() throws Exception{
		 return "startPage";      
	 }
	
	@RequestMapping("/create")
	public String create( @ModelAttribute("dto") @Valid ContentDto contentdto
			, BindingResult result , Model model) {
		
		String page = "DonePage";
		
		if( result.hasErrors() ) {
			if( result.getFieldError("writer") != null ) {  //writer 멤버변수에 대한 에러내용이 존재한다면
				//model.addAttribute("msg", "writer 가 비어 있거나 3글자 미만이면 안됩니다.");
				model.addAttribute("msg", result.getFieldError("writer").getDefaultMessage() );
			}else if( result.getFieldError("content") != null ) { //content 멤버변수에 대한 에러내용이 존재한다면
				//model.addAttribute("msg","content 가 비어 있으면 안됩니다.");
				model.addAttribute("msg", result.getFieldError("content").getDefaultMessage() );
			}
			page = "startPage";
		}
				
		return page;
	}
}
