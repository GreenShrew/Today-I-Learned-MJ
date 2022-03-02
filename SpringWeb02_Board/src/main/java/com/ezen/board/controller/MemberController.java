package com.ezen.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
//	@RequestMapping(value="/", method=RequestMethod.GET)	이렇게 쓰는게 정석이지만 생략 가능한건 생략할 수 있다.
	@RequestMapping("/")
	public String firstRequest(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String url="";
		if(session.getAttribute("loginUser")!=null) {
			url="redirect:/boardList";
		}else {
			url="member/loginForm";
		}
		return url;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String url = "member/loginForm";
		
		MemberDto mdto = ms.getMember(id);	// 아이디를 이용해서 회원을 조회하고, 회원의 모든 정보를 dto 형태로 리턴받는다.
		
		if(mdto==null) {	// 조회된 아이디가 없는 경우
			model.addAttribute("message", "아이디가 없습니다.");
		}else if(mdto.getPw()==null) {	// DB 오류
			model.addAttribute("message", "DB 오류, 관리자에게 문의하세요.");
		}else if(mdto.getPw().equals(pw)) {	// 정상로그인
			url = "redirect:/boardList";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
		}else if(!mdto.getPw().equals(pw)) {	// 비번 틀림
			model.addAttribute("message", "비밀번호가 틀렸습니다.");
		}else {	// 알수 없는 로그인 불가
			model.addAttribute("message", "알수없는 이유로 로그인이 안됩니다..");
		}
		
		return url;
	}
}
