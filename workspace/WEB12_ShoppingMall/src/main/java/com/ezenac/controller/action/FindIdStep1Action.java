package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class FindIdStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/findIdForm.jsp";
		
		// 이름과 전화번호를 전달받아서 저장.
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		// MemberDao에 이름으로 유저의 정보를 긁어오는 메소드를 제작
		// 그리고 긁은 정보를 mvo에 저장
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMemberByname(name);

		// name 과 phone을 다음 페이지로 전송하기 위해 request에 담음.
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		
		if(mvo == null) {
			request.setAttribute("msg", "해당 이름의 회원이 없습니다.");
		}else if(!mvo.getPhone().equals(phone)) {
			request.setAttribute("msg", "잘못된 전화번호입니다.");
			url = "member/findIdForm.jsp";
		}else if(mvo.getPhone().equals(phone)) {
			request.setAttribute("MemberVO", mvo);
			url = "member/findIdconfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
