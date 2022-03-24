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
			@RequestParam(value = "reid", required=false) String reid,
			@RequestParam(value = "pwdCheck", required=false) String pwdCheck,
			HttpServletRequest request,
			Model model) {
		
		// validation 적용 후 해쉬맵에 내용을 담아서 회원가입을 실행한다.
		model.addAttribute("reid");	// reid는 hidden 태그로 숨겨져있다... 이걸 안 하면 아이디 중복체크를 다시 해야한다.
		
		String url = "member/login";
		
		if(result.getFieldError("userid") != null) {
			model.addAttribute("message", result.getFieldError("userid").getDefaultMessage());
			return "member/joinForm";
		}else if(reid == null || ( reid != null && !reid.equals(membervo.getUserid()) )) {
			model.addAttribute("message", "아이디 중복확인을 해주세요.");
			return "member/joinForm";
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
			return "member/joinForm";
		}else if(pwdCheck == null || ( pwdCheck != null && !pwdCheck.equals(membervo.getPwd()) )) {
			model.addAttribute("message", "비밀번호를 입력해주세요.");
			return "member/joinForm";
		}else if(result.getFieldError("name")!=null) {
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
			return "member/joinForm";
		}else if(result.getFieldError("email")!=null) {
			model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
			return "member/joinForm";
		}else if(result.getFieldError("phone")!=null) {
			model.addAttribute("message", "전화번호를 입력해주세요.");
			return "member/joinForm";
		}

		// validation을 통과했다면 HashMap에 내용을 담아 insert 하도록 한다.
		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("userid", membervo.getUserid());
		paramMap.put("pwd", membervo.getPwd());
		paramMap.put("name", membervo.getName());
		paramMap.put("email", membervo.getEmail());
		paramMap.put("phone", membervo.getPhone());
		paramMap.put("zip_num", membervo.getZip_num());
		paramMap.put("address", membervo.getAddress());
		paramMap.put("address2", membervo.getAddress2());
		
		ms.insertMember(paramMap);
		
		model.addAttribute("message", "회원가입이 완료되었습니다. 로그인하세요.");
		return "member/login";
	}
	
	
	@RequestMapping(value="/memberEditForm")
	public String memberEditForm(HttpServletRequest request, Model model) {
		
		MemberVO dto = new MemberVO();
		HttpSession session = request.getSession();
		
		// HashMap에 session의 loginUser의 정보를 넣는다.
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		// 대문자 조심!
		dto.setUserid((String)loginUser.get("USERID"));
		dto.setName((String)loginUser.get("NAME"));
		dto.setEmail((String)loginUser.get("EMAIL"));
		dto.setPhone((String)loginUser.get("PHONE"));
		dto.setZip_num((String)loginUser.get("ZIP_NUM"));
		dto.setAddress((String)loginUser.get("ADDRESS"));
		dto.setAddress2((String)loginUser.get("ADDRESS2"));
		
		model.addAttribute("dto", dto);
		
		return "member/memberUpdateForm";
	}
	
	
	// request join과 거의 비슷하다!
	@RequestMapping(value="/memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result,
			@RequestParam(value = "pwdCheck", required=false) String pwdCheck,
			HttpServletRequest request,
			Model model) {
		
		// validation 적용 후 해쉬맵에 내용을 담아서 회원가입을 실행한다.
		String url = "member/login";
		
		if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
			return "member/memberUpdateForm";
		}else if(pwdCheck == null || ( pwdCheck != null && !pwdCheck.equals(membervo.getPwd()) )) {
			model.addAttribute("message", "비밀번호를 입력해주세요.");
			return "member/memberUpdateForm";
		}else if(result.getFieldError("name")!=null) {
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
			return "member/memberUpdateForm";
		}else if(result.getFieldError("email")!=null) {
			model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
			return "member/memberUpdateForm";
		}else if(result.getFieldError("phone")!=null) {
			model.addAttribute("message", "전화번호를 입력해주세요.");
			return "member/memberUpdateForm";
		}

		// validation을 통과했다면 HashMap에 내용을 담아 update 하도록 한다.
		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("USERID", membervo.getUserid());
		paramMap.put("PWD", membervo.getPwd());
		paramMap.put("NAME", membervo.getName());
		paramMap.put("EMAIL", membervo.getEmail());
		paramMap.put("PHONE", membervo.getPhone());
		paramMap.put("ZIP_NUM", membervo.getZip_num());
		paramMap.put("ADDRESS", membervo.getAddress());
		paramMap.put("ADDRESS2", membervo.getAddress2());
		
		ms.updateMember(paramMap);
		
		// paramMap에 담긴 내용을 session에 담는데, 
		// select로 조회해서 얻어온 내용이 아니므로 위에서 put을 쓸때 소문자를 쓰면 소문자로 쓴 key 값으로 저장되어버린다.
		// 따라서 다른 페이지와 이를 맞추기 위해 put 할때 미리 대문자로 넣는다!
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", paramMap);
		
		return "redirect:/";
	}
}
