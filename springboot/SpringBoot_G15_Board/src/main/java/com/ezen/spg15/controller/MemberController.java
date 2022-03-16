package com.ezen.spg15.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg15.dto.MemberVO;
import com.ezen.spg15.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	
	@RequestMapping("/")
	public String index() {
		return "member/loginForm";
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo, 
			BindingResult result, HttpServletRequest request, Model model) {
//		if(result.hasErrors()) 를 안 쓰는 이유는 userid나 pwd가 다 차 있어도 나머지 멤버변수가 비어있기 때문이다!
		
		if(result.getFieldError("userid")!=null) {
			model.addAttribute("message", result.getFieldError("userid").getDefaultMessage());
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
		}
		
		MemberVO mvo = ms.getMember(membervo.getUserid());
		
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
	
	
	@RequestMapping("/memberJoinForm")
	public String join_form() {
		return "member/memberJoinForm";
	}
	
	
	@RequestMapping("/idcheck")
	public ModelAndView idcheck(@RequestParam("userid") String userid) {
		
		ModelAndView mav = new ModelAndView();
		
		// 중복 아이디가 있는지 확인
		MemberVO mvo = ms.getMember(userid);
		if(mvo==null) {
			mav.addObject("result", -1);
		}else {
			mav.addObject("result", 1);
		}
		
		mav.addObject("userid",userid);
		mav.setViewName("member/idcheck");
		
		return mav;
	}
	
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public ModelAndView memberJoin(
			@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result,
			@RequestParam("re_id") String reid,
			@RequestParam("pwd_check") String pwchk,
			Model model) {
		
		ModelAndView mav = new ModelAndView();
		
		// validation으로 전송된 값들을 점검하고, null이나 빈칸이 있으면 memberJoinForm.jsp로 되돌아간다.
		
		// MemberVO로 자동으로 들어가지 않는 전달인수 - pwd_check, re_id는 별도의 변수로 전달받고,
		// 별도로 이상 유무를 체크하고 이상이 있을시 memberJoinForm.jsp로 되돌아간다.
		
		// 모두 이상이 없다고 점검이 되면 회원가입 시키고, 회원가입 완료라는 메세지와 함께 loginForm.jsp로 되돌아간다.
		
		mav.setViewName("member/memberJoinForm");	// 되돌아갈 페이지의 기본은 회원가입 페이지
		if(reid != null && reid.equals("")) {
			mav.addObject("re_id", reid);
		}
		
		
		if(result.getFieldError("userid")!=null) {
			mav.addObject("message", "아이디를 입력하세요.");
		}else if(result.getFieldError("pwd")!=null) {
			mav.addObject("message", "비밀번호를 입력하세요.");
		}else if(result.getFieldError("name")!=null) {
			mav.addObject("message", result.getFieldError("name").getDefaultMessage());
		}else if(!membervo.getUserid().equals(reid)) {
			mav.addObject("message", "아이디 중복체크가 되지 않았습니다.");
		}else if(!membervo.getPwd().equals(pwchk)) {
			mav.addObject("message", "비밀번호 확인이 일치하지 않습니다.");
		}else if(result.getFieldError("email")!=null) {
			mav.addObject("message", result.getFieldError("email").getDefaultMessage());
		}else if(result.getFieldError("phone")!=null) {
			mav.addObject("message", result.getFieldError("phone").getDefaultMessage());
		}else{
			ms.insertMember(membervo);
			mav.addObject("message", "회원가입이 완료되었습니다. 로그인해주세요.");
			mav.setViewName("member/loginForm");	// 정상 회원가입이 이루어졌을 때 로그인폼으로 이동 목적지를 변경
		}
		
		return mav;
	}
	
	
	@RequestMapping("/memberEditForm")
	public ModelAndView mem_edit_form(Model model, HttpServletRequest request) {
		// memberEditForm.jsp에서 최초 데이터는 session에서 받아오는 식, ${loginUser.userid} 로 했으나,
		// validation을 적용하기 힘들어지므로 모두 ${dto.userid}로 바꾸었다.
		// 따라서 초기 값은 session 값을 dto에 먼저 넣고 보내기로 한다.
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");	// 세션값을 dto에 저장
		mav.addObject("dto", mvo);	// 저장한 값을 dto 라는 이름으로 JSP로 전송
		mav.setViewName("member/memberEditForm");
		
		return mav;
	}
	
	
	@RequestMapping(value="/memberEdit", method=RequestMethod.POST)
	public String memberEdit(
			@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result,
			@RequestParam("pwd_check") String pwchk,
			Model model,
			HttpServletRequest request) {
		
		String url = "member/memberEditForm";	// 입력이 잘못되어있다면 되돌아갈 링크
		
		if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message", "비밀번호를 입력하세요.");
		}else if(result.getFieldError("name")!=null){
			model.addAttribute("message", "이름을 입력하세요.");
		}else if(!membervo.getPwd().equals(pwchk)){
			model.addAttribute("message", "비밀번호 확인이 일치하지 않습니다..");
		}else {
			ms.updateMember(membervo);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", membervo);
			url = "redirect:/main";
		}
		return url;
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
