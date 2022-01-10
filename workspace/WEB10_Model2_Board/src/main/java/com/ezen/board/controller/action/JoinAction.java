package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달인수들을 모두 Dto에 담고, inertMember에 보내주는 역할을 한다.
		MemberDto mdto = new MemberDto();

		mdto.setUserid(request.getParameter("userid"));
		mdto.setName(request.getParameter("name"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		
		if(result==1) request.setAttribute("message", "회원가입이 완료되었습니다.");
		else request.setAttribute("message", "회원가입에 실패했습니다. 관리자에게 문의하세요");
		
		RequestDispatcher dp =request.getRequestDispatcher("board.do?command=index");
		dp.forward(request, response);
	}

}
