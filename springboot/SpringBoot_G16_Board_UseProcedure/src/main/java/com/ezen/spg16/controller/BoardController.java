package com.ezen.spg16.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg16.dto.Paging;
import com.ezen.spg16.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@RequestMapping("/main")
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) {
			mav.setViewName("loginform");
		}else {	// 게시판 내용을 가져오는 내용은 앞선 memberController의 getMember 메소드와 거의 비슷하다!
			
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
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			
			Paging paging = new Paging();
			paging.setPage(page);
			
//			int count = bs.getAllCount();
			paramMap.put("cnt", 0);	// cnt 라는 이름의 값을 하나 만들어서 이를 paramMap에 저장하고
			bs.getAllCount(paramMap);	// cnt가 저장된 paramMap을 보내고,
			// getAllCount 에서 얻어서 cnt에 저장한 값을 꺼내 쓴다.
			int count = (Integer) paramMap.get("cnt");
			
			paging.setTotalCount(count);
			paging.paging();
			
			paramMap.put("ref_cursor",null); // ref_cursor에 게시판 리스트가 모조리 들어온다!
//			paramMap.put("paging", paging);
			// paging 객체를 보내서 ~~.getStartNum() 이런식으로 해도 좋지만,
			// 아예 여기서 startNum, endNum에 담아서 보낸다.
			paramMap.put("startNum", paging.getStartNum());
			paramMap.put("endNum", paging.getEndNum());
			
			
			bs.selectBoard(paramMap);
			
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");

			mav.addObject("boardList", list);
			mav.addObject("paging", paging);
			mav.setViewName("board/main");
			
		}
		return mav;
	}
}
