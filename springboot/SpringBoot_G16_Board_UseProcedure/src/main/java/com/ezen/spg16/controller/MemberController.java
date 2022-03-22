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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg16.dto.MemberVO;
import com.ezen.spg16.service.MemberService;

@Controller
public class MemberController {

	@Autowired 
	MemberService ms;
	
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser")==null)
			return "member/loginForm";
		else 
			return "redirect:/main";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login( @ModelAttribute("dto") @Valid MemberVO membervo , BindingResult result, 
			HttpServletRequest request, Model model ) {
		
		if( result.getFieldError("userid") != null ) {
			model.addAttribute("message", result.getFieldError("userid").getDefaultMessage() );
			return "member/loginForm";
		}else if( result.getFieldError("pwd")!=null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage() );
			return "member/loginForm";
		}
		
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", membervo.getUserid() );
		paramMap.put("ref_cursor", null);
		
		ms.getMember( paramMap );  
		// 오라클 프로시져에서 커서에 담겨오는 자료형은 한개이상의 레코드들 입니다
		// 위 getMember 의 결과는 아이디로 검색한 한명의 데이이터 이지만, 결과는 리스트형태로 담겨옵니다
		// 그중 첫번째를 MemberVO 에 꺼내어 담아서 사용합니다
		
		//1. 리스트부터 꺼냅니다
		ArrayList< HashMap<String, Object> >list 
			= (ArrayList< HashMap<String, Object> >)paramMap.get("ref_cursor");
		// 프로시져의 결과는 레코드의 리스트들인데, 각 레코드는 <필드명, 필드값> 형태의 해쉬맵입니다. 
		// 해쉬맵 하나가 하나의 레코드를 이루고 그안에는 각 필드명과 값들이 들어있습니다. 그 레코들의 집합이  ref_cursor 라는
		// 키에 저장되어 돌아와 있는 형태입니다
		
		// * 리스트의 결과가 아무것도 없는지를 먼저 조사합니다.
		if( list.size() == 0 ) {
			model.addAttribute("message", "아이디가 없습니다");
			return "member/loginForm";
		}
		//2. 리스트의 첫번째 항목을 mvo 에 담습니다
		HashMap<String , Object > mvo = list.get(0);
		//System.out.println( mvo.get("USERID") );
		//System.out.println( mvo.get("NAME") );
		//System.out.println( mvo.get("PWD") );
		//System.out.println( mvo.get("PHONE") );
		//System.out.println( mvo.get("EMAIL") );
		
		if( mvo.get("PWD") == null ) {
			model.addAttribute("message", "비밀번호 오류. 관리자에게 문의하세요");
			return "member/loginForm";
		}else if( !mvo.get("PWD").equals( membervo.getPwd() ) ) {
			model.addAttribute("message", "비밀번호가 맞지않습니다");
			return "member/loginForm";
		}else if( mvo.get("PWD").equals( membervo.getPwd() ) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo );
			return "redirect:/main";
		}else {
			model.addAttribute("message", "무슨이유인지 모르겠지만 로그인 안돼요");
			return "member/loginForm";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping("/memberJoinForm")
	public String join_form( ) {
		return "member/memberJoinForm";
	}
	
	
	@RequestMapping("/idcheck")
	public ModelAndView idcheck( @RequestParam("userid") String userid ) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String , Object> paramMap = new HashMap<String , Object>();
		paramMap.put("userid", userid);
		paramMap.put("ref_cursor", null);
		ms.getMember( paramMap );
		ArrayList< HashMap<String , Object> > list 
			= ( ArrayList< HashMap<String , Object> > )paramMap.get("ref_cursor");
		
		if( list.size() == 0 ) mav.addObject("result" , -1);
		else mav.addObject("result", 1);
		
		mav.addObject("userid", userid);
		mav.setViewName("member/idcheck");
		
		return mav;
	}
	
	
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public ModelAndView memberJoin( 
			@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result, 
			@RequestParam("re_id") String reid, 
			@RequestParam("pwd_check") String pwchk, 
			Model model ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberJoinForm");  
		if( reid != null && reid.equals("") ) mav.addObject("re_id", reid);
		if( result.getFieldError("userid")!=null) 
			mav.addObject("message", "아이디 입력하세요");
		else if( result.getFieldError("pwd") != null ) 
			mav.addObject("message", "비밀번호 입력하세요");
		else if( result.getFieldError("name") != null ) 
			mav.addObject("message", result.getFieldError("name").getDefaultMessage() );
		else if( !membervo.getUserid().equals(reid)) 
			mav.addObject("message","아이디 중복체크가 되지 않았습니다");
		else if( !membervo.getPwd().equals(pwchk)) 
			mav.addObject("message","비밀번호 확인이 일치하시 않습니다.");
		else {  
			//ms.insertMember( membervo );
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userid", membervo.getUserid());
			paramMap.put("pwd", membervo.getPwd());
			paramMap.put("name", membervo.getName());
			paramMap.put("email", membervo.getEmail());
			paramMap.put("phone", membervo.getPhone());
			ms.insertMember( paramMap );
			mav.addObject("message", "회원가입이 완료되었습니다. 로그인 하세요");
			mav.setViewName("member/loginForm"); // 정상 회원가입이 이루어졌을때 로그인폼으로 이동 목적지를 바꿉니다
		}
		return mav;
	}
	
	@RequestMapping("/memberEditForm")
	public ModelAndView mem_edit_form(Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser 
			= (HashMap<String, Object>)session.getAttribute("loginUser");
		
		MemberVO dto = new MemberVO();
		dto.setUserid( (String)loginUser.get("USERID") );
		dto.setPwd( (String)loginUser.get("PWD") );
		dto.setName( (String)loginUser.get("NAME") );
		dto.setEmail( (String)loginUser.get("EMAIL") );
		dto.setPhone( (String)loginUser.get("PHONE") );		
		
		mav.addObject("dto", dto);
		mav.setViewName("member/memberEditForm");
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/memberEdit" , method=RequestMethod.POST)
	public String memberEdit( 
			@ModelAttribute("dto") @Valid MemberVO membervo ,
			BindingResult result, 
			@RequestParam("pwd_check") String pwchk,  
			Model model, 
			HttpServletRequest request ) {
		
		String url = "member/memberEditForm";
		
		if( result.getFieldError("pwd") != null )
			model.addAttribute("message" , "비밀번호 입력하세요");
		else if( result.getFieldError("name") != null )
			model.addAttribute("message" , "이름 입력하세요");
		else if( !membervo.getPwd().equals(pwchk)) 
			model.addAttribute("message","비밀번호 확인이 일치하시 않습니다.");
		else { 
			
			HashMap<String , Object> mvo = new HashMap<String, Object>();
			mvo.put("USERID", membervo.getUserid() );
			mvo.put("PWD", membervo.getPwd() );
			mvo.put("NAME", membervo.getName() );
			mvo.put("EMAIL", membervo.getEmail() );
			mvo.put("PHONE", membervo.getPhone() );
			ms.updateMember( mvo );
			
			/*
			ms.updateMember(membervo);
			HashMap<String , Object> paramMap = new HashMap<String, Object>();
			paramMap.put("refcursor", null);
			ms.getMember(paramMap);
			ArrayList<HashMap<String , Object>>list 
				= (ArrayList<HashMap<String , Object>>)paramMap.get("ref_cursor"); 
			HashMap<String , Object> mvo = list.get(0);
			*/
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			url = "redirect:/main";
		} 
		return url;
	}
}










