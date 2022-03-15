package com.ezen.spg15.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg15.dto.Paging;
import com.ezen.spg15.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping("/main")
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			mav.setViewName("loginForm");
		}else {
			// 페이징 처리
			int page = 1;
			if(request.getParameter("page") != null) {	// 전달된 페이지값이 있는지
				page = Integer.parseInt(request.getParameter("page"));	// 있다면 페이지 session에 저장해두기
				session.setAttribute("page", page);
			}else if(session.getAttribute("page") != null) {	// 이전에 저장해둔 page가 있는지
				page = (int) session.getAttribute("page");	// 있다면 페이지 가져오기
			}else {
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			int count = bs.getAllCount();
			paging.setTotalCount(count);
			paging.paging();	// 페이징 수동실행
			
			mav.addObject("boardList", bs.selectBoardAll(paging));
			mav.addObject("paging", paging);
			mav.setViewName("board/main");
		}
		return mav;
	}
}
