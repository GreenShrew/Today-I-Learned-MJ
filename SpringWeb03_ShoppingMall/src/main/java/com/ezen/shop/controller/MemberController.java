package com.ezen.shop.controller;

import java.util.List;

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
	
	
	
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/contract")
	public String contract(Model model, HttpServletRequest request) {
		return "member/contract";
	}
	
	
	
	@RequestMapping(value="joinForm", method=RequestMethod.POST)
	public String join_form(Model model, HttpServletRequest request) {
		return "member/joinForm";
	}

	
	
	
	@RequestMapping("idCheckForm")
	public String id_check_form(Model model, HttpServletRequest request) {
		String userid = request.getParameter("userid");
		MemberVO mvo = ms.getMember(userid);
		if( mvo == null ) model.addAttribute("result", -1);
		else model.addAttribute("result", 1);
		
		model.addAttribute("userid", userid);
		
		return "member/idcheck";
	}
	
	
	
	
	@RequestMapping("/findZipNum")
	public String find_zip(Model model, HttpServletRequest request) {
		String dong=request.getParameter("dong");
		
		if(dong!=null && dong.trim().equals("")==false){
			//List<AddressVO> addressList = ms.slelectAddressByDong(dong);
			//model.addAttribute(  "addressList", addressList  );
			model.addAttribute(  "addressList", ms.selectAddressByDong(dong)  );
		}
		return "member/findZipNum";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(Model model, HttpServletRequest request) {
		
		MemberVO mvo = new MemberVO();
		mvo.setUserid(request.getParameter("userid"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress(request.getParameter("addr1") );
		mvo.setAddress2( request.getParameter("addr2") );
		ms.insertMember(mvo);
		
		return "member/login";
	}
	
	
	@RequestMapping(value = "memberEditForm")
	public String member_Edit_Form(Model model, HttpServletRequest request) {
		
		return "member/memberUpdateForm";
	}
	
	
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String member_Update(Model model, HttpServletRequest request) {
		MemberVO mvo = new MemberVO();
		mvo.setUserid(request.getParameter("userid"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress(request.getParameter("addr1") );
		mvo.setAddress2( request.getParameter("addr2") );		
		mvo.setPhone(request.getParameter("phone"));
		
		ms.memberUpdate(mvo);
		
		HttpSession session=request.getSession();
		session.setAttribute("loginUser", mvo);
		return "redirect:/";
	}
}













