package com.ezen.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@RequestMapping("/boardList")
	public String main(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) {
			return "member/loginForm";
		}else {
			ArrayList<BoardDto> list = bs.getBoardsMain();
			model.addAttribute("boardList", list);
		}
		return "board/main";
	}
}
