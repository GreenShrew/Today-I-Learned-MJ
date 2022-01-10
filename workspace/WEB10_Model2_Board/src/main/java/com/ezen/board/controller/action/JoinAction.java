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
		
		// if(result==1) request.setAttribute("message", "회원가입이 완료되었습니다.");
		// else request.setAttribute("message", "회원가입에 실패했습니다. 관리자에게 문의하세요");
		
		// 다음 페이지에서 새로고침하면 계속 같은 내용으로 회원가입을 시도하게 된다.
		// 그렇기에 새로고침해서 이전 페이지의 데이터를 계속 불러오지 않도록 하기 위해서는 sendRedirect를 이용.
		// RequestDispatcher dp =request.getRequestDispatcher("board.do?command=index");
		// dp.forward(request, response);
		
		String message = "";
		if(result==1) message = "회원가입 완료";
		else message = "회원가입 실패";
		
		
		// forwarding 메소드로 이동한 최종 도착 페이지에서는 새로고침을 하면 데이터도 한번 더 추가되려고 시도한다.
		// 새로고침에 의해 Forwarding 이전 코드가 다시 실행되지 않도록 하려면 sendRedirect를 이용한다.
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect("board.do?command=index&message=" + message);
	}

}
