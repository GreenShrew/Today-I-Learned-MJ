package com.ezen.spg16.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.spg16.dto.MemberVO;
import com.ezen.spg16.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			return "member/loginForm";
		}else {
			return "redirect:/main";
		}
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo, 
			BindingResult result, HttpServletRequest request, Model model) {
		
		if(result.getFieldError("userid")!=null) {
			model.addAttribute("message", result.getFieldError("userid").getDefaultMessage());
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
		}
		
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", membervo.getUserid());	// 보낼 id 값
		paramMap.compute("ref_cursor", null);			// 프로시져의 select 결과를 받아올 공간
		// 어떤 형식을 받을지 모르므로 null을 넣는다.
		
//		MemberVO mvo = ms.getMember(membervo.getUserid());
		ms.getMember(paramMap);
		// 오라클 프로시져에서 커서에 담겨오는 자료형은 한개 이상의 레코드들이다.
		// 위 getMember의 결과는 아이디로 검색한 한명의 데이터이지만, 결과는 리스트 형태로 담겨온다.
		// 그 중 첫번째를 MemberVO에 꺼내어 담아서 사용한다.
		
		// 1. 리스트부터 꺼낸다.
		
		// 2. 리스트의 첫번째 항목을 mvo에 담는다.
		
		
		
		if(mvo == null) {
			model.addAttribute("message", "아이디가 없습니다.");
			return "loginForm";
		}else if(mvo.getPwd() == null) {
			model.addAttribute("message", "로그인 오류. 관리자에게 문의하세요.");
			return "loginForm";
		}else if(!mvo.getPwd().equals(membervo.getPwd())) {
			model.addAttribute("message", "비밀번호가 맞지 않습니다.");
			return "loginForm";
		}else if(mvo.getPwd().equals(membervo.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			return "redirect:/main";
		}else {
			model.addAttribute("message", "무슨 이유인지는 모르겠으나 로그인이 되지 않습니다.");
			return "loginForm";
		}
	}
}
