package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// loginForm으로부터 넘어온 userid, pwd 파라미터를 받는다.
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		// Dao에서 getMember 메소드에서 userid로 검색한 회원의 정보가 mdto에 저장된다.
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp";
		
		if(mdto == null) {
			request.setAttribute("message", "아이디가 없습니다.");
		}else if(mdto.getPwd() == null) {
			request.setAttribute("message", "비밀번호 오류! 관리자에게 문의하세요.");
		}else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 틀립니다.");
		}else if(mdto.getPwd().equals(pwd)){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
			url = "board.do?command=main";
		}else {
			request.setAttribute("message", "왜 로그인이 안 되는걸까요.");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
