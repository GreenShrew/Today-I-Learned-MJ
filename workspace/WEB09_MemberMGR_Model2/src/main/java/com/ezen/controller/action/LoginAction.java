package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class LoginAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp";	// 로그인 실패시 srl
		if(mdto == null) {
			request.setAttribute("message", "없는 아이디입니다.");		// 메세지를 가지고 간다.
		}else if(mdto.getPwd() == null) {
			request.setAttribute("message", "비밀번호 오류입니다.");
		}else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(mdto.getPwd().equals(pwd)) {	// 로그인 성공
			url = "main.jsp";
			// 로그인에 성공하면 세션에 해당 회원의 정보를 loginUser라는 이름으로 저장해서 로그아웃 될 때까지 유지시킨다.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
		}else {
			request.setAttribute("message", "대체 왜 로그인이 안 되는거지?????");
		}
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);		// url 주소로 Forwarding
	}
}
