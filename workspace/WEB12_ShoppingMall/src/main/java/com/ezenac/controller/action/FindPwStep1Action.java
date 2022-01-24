package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class FindPwStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		String url = "member/findPwForm.jsp";	// 실패시 여기로
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		
		if(mvo == null) {
			request.setAttribute("msg", "id와 이름과 전화번호가 일치하는 회원이 없습니다.");
		}else if((!name.equals(mvo.getName())) || (!phone.equals(mvo.getPhone()))) {
			request.setAttribute("msg", "id와 이름과 전화번호가 일치하는 회원이 없습니다.");
		}else {
			url = "member/findPwconfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
