package com.ezen.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/")		// method가 생략되면 value= 이것도 생략하고 이렇게 쓰면 된다.
	public String loginForm() {
		return "member/loginForm";
	}
}
