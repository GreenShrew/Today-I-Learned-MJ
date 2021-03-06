package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/loginForm.jsp";
		HttpSession session = request.getSession();

		// parameter로 들어오는 값을 setAttribute로 받으면 이후에 EL문을 사용할 때 ${param.message}와 같이 쓰지 않고
		// ${message}만 써도 된다.
		request.setAttribute("message", request.getParameter("message"));
		
		if( session.getAttribute("loginUser") != null ) 
			url = "board.do?command=main";
			
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}
}
