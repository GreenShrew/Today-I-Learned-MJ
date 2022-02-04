package com.ezen.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired	// SpringContext에 MemberService가 있어야 Autowired가 가능한데...이걸 또 넣어야해?
	// 아니다! 이젠 bean을 추가하지 않아도 된다! 상단에 @Controller를 붙여준다! 그리고 MemberService 클래스 상단으로 이동해보자!
	MemberService ms;
	
	@RequestMapping("/")		// method가 생략되면 value= 이것도 생략하고 이렇게 쓰면 된다.
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login")		// method가 생략되면 value= 이것도 생략하고 이렇게 쓰면 된다.
	public String login(HttpServletRequest request) {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 옛날 방식의 dao 호출방법! 사람이 많아질수록 호출되는 숫자가 많아지기 떄문에 안 쓴다!
//		MemberDao mdao = new MemberDao(); 위의 @Autowired로 가보자
		
		MemberDto mdto = ms.getMember(id);	// MemberService 클래스로 간다.
		
		return "board/main.jsp";
	}
}
