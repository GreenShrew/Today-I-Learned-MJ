package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong = request.getParameter("dong");
		if(dong != null) {
			
		}
		RequestDispatcher dp = request.getRequestDispatcher("member/findZipNum.jsp");
		dp.forward(request, response);
	}

}
