package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dto.MemberVO;

public class FindIdStep2Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String confirmNum = request.getParameter("confirmNum");
		
		// findIdconfirmNumber.jsp 에서 전달된 id, name, phone을 저장
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setName(request.getParameter("name"));
		mvo.setPhone(request.getParameter("phone"));
		request.setAttribute("name", mvo.getName());
		request.setAttribute("phone", mvo.getPhone());
		request.setAttribute("id", mvo.getId());
		request.setAttribute("MemberVO", mvo);
		
		String url = "member/viewId.jsp";
		if(!confirmNum.equals("0000")) {	// 인증번호는 일단 0000으로 셋팅
			request.setAttribute("msg", "인증번호가 맞지 않습니다");
			url = "member/findIdconfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
