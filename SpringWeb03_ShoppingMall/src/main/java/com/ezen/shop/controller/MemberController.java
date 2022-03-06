package com.ezen.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.shop.dto.MemberVO;
import com.ezen.shop.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping("loginForm")
	public String login_form(Model model, HttpServletRequest request) {
		return "member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVO mvo = ms.getMember(id);
		if( mvo == null) {
			model.addAttribute("message", "ID가 없습니다");
			return "member/login";
		} else if( mvo.getPwd() == null ) {
			model.addAttribute("message", "관리자에게 문의하세요");
			return "member/login";
		} else if( !mvo.getPwd().equals(pwd) ) {
			model.addAttribute("message", "비번이 맞지 않습니다");
			return "member/login";
		} else if( mvo.getPwd().equals(pwd) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			return "redirect:/";
		} else {
			model.addAttribute("message", "알수없는 이유로 로그인이 안됩니다");
			return "member/login";
		}
	}
	
	
	
}













