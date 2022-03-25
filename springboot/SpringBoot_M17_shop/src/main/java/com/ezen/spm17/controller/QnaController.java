package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.QnaService;

@Controller
public class QnaController {

	@Autowired
	QnaService qs;
	
	
	@RequestMapping(value="/qnaList")
	public ModelAndView qna_list(Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mav.setViewName("member/login");
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userid", loginUser.get("USERID"));
			paramMap.put("ref_cursor", null);
			qs.listQna(paramMap);
			
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			mav.addObject("qnaList", list);
			mav.setViewName("qna/qnaList");
		}
		return mav;
	}
	
	
	@RequestMapping("/qnaView")
	public ModelAndView qna_view( HttpServletRequest request,
			@RequestParam("qseq") int qseq) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mav.setViewName("member/login");
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("qseq", qseq);
			paramMap.put("ref_cursor", null);
			qs.getQna(paramMap);
			
			ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			mav.addObject("qnaVO", list.get(0));
			mav.setViewName("qna/qnaView");
		}
		return mav;
	}
	
	
	@RequestMapping("/qnaWriteForm")
	// 로그인 체크만 해서 이동하는것이므로 ModelAndView가 굳이 필요하지는 않다.
	public String qna_write_form(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		}
		return "qna/qnaWrite";
	}
	
}
