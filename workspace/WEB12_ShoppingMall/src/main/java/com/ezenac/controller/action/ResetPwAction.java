package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class ResetPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디와 패스워드를 전달받아서
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setId(request.getParameter("pwd"));
		
		// 패스워드를 수정하고
		MemberDao mdao = MemberDao.getInstance();
		mdao.resetPw(mvo);
		
		// 패스워드 리셋 완료 페이지로 이동한다.
		String url = "member/resetPwComplete.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
