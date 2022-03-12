package com.ezen.spg03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

	String name4;
	String name5;
	
	@RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Model & View";
    }
	
	
	@RequestMapping("/test1")
    public String test1(Model model, HttpServletRequest request) {
		
		// 리턴되는 jsp 파일까지만 해당 내용을 전달 할수 있는 1회용 자료 전달 도구
		model.addAttribute("name1", "홍길동");
		// request 의 수명이 다하는 순간까지는 내용을 살려서 다시 전달 할 수 있는 전달 도구
		request.setAttribute("name2" , "김하나");
		
		return "test1";
	}
	
	@RequestMapping("/test2")
    public String test2(Model model, HttpServletRequest request) {
		
		model.addAttribute("name1", "홍길동");
		request.setAttribute("name2" , "김하나");
        request.setAttribute("model", model);
        name4 = "홍길동";
        name5 = "김하나";
		return "redirect:/test3";
	}
	
	@RequestMapping("/test3")
    public String test3(Model model, HttpServletRequest request) {
		String name1 = (String)model.getAttribute("name1");
		String name2 = (String)request.getAttribute("name2");
		System.out.println(name1 + " " + name2);
		//model.addAttribute("name1", name1);
		//request.setAttribute("name2", name2);
		//model = (Model) request.getAttribute("model");
		//String name2 = (String)request.getAttribute("name2");
		
		model.addAttribute("name1", name4);
		request.setAttribute("name2" , name5);
		return "test2";
	}
	
	
	@RequestMapping("/mv")
    public ModelAndView test2() {
    	// 데이터와 뷰를 동시에 설정이 가능
        ModelAndView mv = new ModelAndView();
        List<String> list = new ArrayList<String>();
        list.add("test1");   
        list.add("test2");     
        list.add("test3");
        mv.addObject("lists", list);      
        mv.addObject("ObjectTest", "테스트입니다."); 
        mv.addObject("name", "홍길동");	   
        mv.setViewName("view/myView");
        return mv;    
	}
		
}









