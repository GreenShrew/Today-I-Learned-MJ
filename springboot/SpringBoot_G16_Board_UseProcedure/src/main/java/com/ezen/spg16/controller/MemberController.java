package com.ezen.spg16.controller;

import java.util.ArrayList;
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
		paramMap.put("userid", membervo.getUserid());	// 보낼 id 값
		paramMap.put("ref_cursor", null);			// 프로시져의 select 결과를 받아올 공간
		// 어떤 형식을 받을지 모르므로 null을 넣는다.
		
//		MemberVO mvo = ms.getMember(membervo.getUserid());
		ms.getMember(paramMap);
		// 오라클 프로시져에서 커서에 담겨오는 자료형은 한개 이상의 레코드들이다.
		// 위 getMember의 결과는 아이디로 검색한 한명의 데이터이지만, 결과는 리스트 형태로 담겨온다.
		// 그 중 첫번째를 MemberVO에 꺼내어 담아서 사용한다.
		
		// 1. 리스트부터 꺼낸다. HashMap 형태로 들어와있다.
		ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		// 프로시져의 결과는 레코드의 리스트들인데, 각 레코드는 <필드명, 필드값> 형태의 해쉬맵이다.
		// 해쉬맵 하나가 하나의 레코드를 이루고, 그 안에는 각 필드명과 값들이 들어있다. 그 레코드들의 집합이 ref_cursor라는
		// 키에 저장되어 돌아와있는 형태이다.
		
		// * 리스트의 결과가 아무것도 없는지를 먼저 조사한다. (데이터가 없는데 get() 메소드를 쓰면 에러가 나온다.)
		if(list.size() == 0) {
			model.addAttribute("message", "아이디가 없습니다.");
			return "loginForm";
		}
		
		// 2. 리스트의 첫번째 항목을 mvo에 담는다. (이제는 MemberVO를 쓰지 않게 되었다)
		HashMap<String, Object> mvo = list.get(0);
		// 이를 get() 메소드로 가져와서 사용할 수 있다...
		// 근데 필드명을 대문자로 써주어야 한다!
		// 아래는 mvo.get(); 으로 진짜 전달되는지 확인하는 용도의 println이다.
//		System.out.println(mvo.get("USERID"));
//		System.out.println(mvo.get("NAME"));
//		System.out.println(mvo.get("PWD"));
//		System.out.println(mvo.get("PHONE"));
//		System.out.println(mvo.get("EMAIL"));
		
		
		if(mvo.get("PWD") == null) {
			model.addAttribute("message", "로그인 오류. 관리자에게 문의하세요.");
			return "loginForm";
		}else if(!mvo.get("PWD").equals(membervo.getPwd())) {
			model.addAttribute("message", "비밀번호가 맞지 않습니다.");
			return "loginForm";
		}else if(mvo.get("PWD").equals(membervo.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			return "redirect:/main";
		}else {
			model.addAttribute("message", "무슨 이유인지는 모르겠으나 로그인이 되지 않습니다.");
			return "loginForm";
		}
	}
}
