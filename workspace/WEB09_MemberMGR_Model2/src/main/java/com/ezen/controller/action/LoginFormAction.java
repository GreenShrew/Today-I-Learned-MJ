package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/loginForm.jsp";
		
		// session을 확인해서 로그인 한 사람이 있다면 main 화면으로 날린다.
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null) {
			url = "member.do?command=main";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);		// servlet에서 받은 매개변수를 이용하여 Forwarding한다!
	}
}
