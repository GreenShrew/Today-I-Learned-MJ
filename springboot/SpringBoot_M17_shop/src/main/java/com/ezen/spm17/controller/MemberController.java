package com.ezen.spm17.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spm17.dto.MemberVO;
import com.ezen.spm17.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping(value="loginForm")
	public String login_form() {
		return "member/login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result,
			HttpServletRequest request,
			Model model) {
		
		// validation 체크
		if(result.getFieldError("userid")!=null) {
			model.addAttribute("message", "아이디를 입력하세요.");
			return "member/login";
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", "패스워드를 입력하세요.");
			return "member/login";
		}else {
			// validation 체크 통과시 입력한 아이디 비밀번호 체크
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userid", membervo.getUserid());
			paramMap.put("ref_cursor", null);
			
			// 아이디로 해당 아이디 정보 조회
			ms.getMember(paramMap);
			
			// getMember() 메소드로 조회한 정보를 list에 저장
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			if(list.size() == 0) {		// 조회된 아이디가 없다면 저장된게 없으니 list의 크기는 0이다.
				model.addAttribute("message", "아이디가 없어요.");
				return "member/login";
			}
			
			// ArratList 형태의 객체 list에 저장된 첫번째 값을 빼내어서 mvo에 저장
			HashMap<String, Object> mvo = list.get(0);
			if(mvo.get("PWD")==null) {
				model.addAttribute("message", "관리자에게 문의하세요.");
				return "member/login";
			}else if(membervo.getPwd().equals((String)mvo.get("PWD"))) {	// 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", mvo);
				return "redirect:/";
			}else {
				model.addAttribute("message", "비밀번호가 안 맞아요.");
				return "member/login";
			}
		}
	}
	
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/contract")
	public String contract() {
		return "member/contract";
	}
	
	
	@RequestMapping(value="/joinForm", method=RequestMethod.POST)
	public String join_form() {
		return "member/joinForm";
	}
	
	
	@RequestMapping("/idCheckForm")
	public String id_check_form(@RequestParam("userid") String userid,
			Model model, HttpServletRequest request) {
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ref_cursor", null);
		paramMap.put("userid", userid);
		
		// 이전에 만든 메소드 재사용
		ms.getMember(paramMap);
		
		ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		if(list.size() == 0) {
			model.addAttribute("result", -1);
		}else {
			model.addAttribute("result", 1);
		}
		
		model.addAttribute("userid", userid);
		return "member/idcheck";
	}
	
	
	@RequestMapping(value="/findZipNum")
	public String find_zip(HttpServletRequest request, Model model) {
		String dong = request.getParameter("dong");
		
		// addressVO 가 아니라 HashMap을 썼다.
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if(dong != null && dong.trim().equals("") == false) {
			paramMap.put("ref_cursor", null);
			paramMap.put("dong", dong);
			
			ms.selectAddressByDong(paramMap);
			
			ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			model.addAttribute("addressList", list);
		}
		return "member/findZipNum";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result,
			@RequestParam("reid") String reid,
			Model model) {
		// validation 적용 후 해쉬맵에 내용을 담아서 회원가입을 실행한다.
		if(result.getFieldError("userid") != null) {
			model.addAttribute("message", "아이디를 입력해주세요.");
			return "member/joinForm";
		}else if(reid != null) {
			model.addAttribute("message", "아이디 중복확인을 해주세요.");
			return "member/joinForm";
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", "비밀번호를 입력해주세요.");
			return "member/joinForm";
		}else if(result.getFieldError("name")!=null) {
			model.addAttribute("message", "이름을 입력해주세요.");
			return "member/joinForm";
		}else if(result.getFieldError("email")!=null) {
			model.addAttribute("message", "이메일을 입력해주세요.");
			return "member/joinForm";
		}else if(result.getFieldError("phone")!=null) {
			model.addAttribute("message", "전화번호를 입력해주세요.");
			return "member/joinForm";
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();

			paramMap.put("userid", membervo.getUserid());
			paramMap.put("pwd", membervo.getPwd());
			paramMap.put("name", membervo.getName());
			paramMap.put("email", membervo.getEmail());
			paramMap.put("phone", membervo.getPhone());
			paramMap.put("zip_num", membervo.getZip_num());
			paramMap.put("address", membervo.getAddress());
			
			ms.join(paramMap);

			
			model.addAttribute("message", "회원가입이 완료되었습니다. 로그인하세요.");
			return "member/login";
		}
		
	}
}
