package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindPwStep2Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// findPwconfirmNumber.jsp 에서 전송된 인증번호를 저장
		String confirmNum = request.getParameter("confirmNum");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		
		String url = "member/findPwconfirmNumber.jsp";
		
		if(confirmNum.equals("0000")) {
			url="member/resetPw.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
