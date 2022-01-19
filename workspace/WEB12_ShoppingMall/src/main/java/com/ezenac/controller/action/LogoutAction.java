package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		// newitem, bestitem을 다시 조회해서 메인 페이지로 가야하므로 command index를 거쳐가도록 만들었다.
		RequestDispatcher dp = request.getRequestDispatcher("shop.do?command=index");
		dp.forward(request, response);
	}

}
