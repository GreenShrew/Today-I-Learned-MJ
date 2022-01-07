package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다른 페이지에서 정보를 넘겨받지 말고, 그냥 접속된 session을 이용한다.
		HttpSession session= request.getSession();
		// session은 object 형식이므로 형변환 절차가 필요.
		MemberDto mdto = (MemberDto) session.getAttribute("loginUser");
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.deleteMember(mdto.getUserid());	// 어차피 삭제할거니깐 해당 유저를 검색할 userid만 보내준다.
		
		session.invalidate();
		
		request.setAttribute("message", "회원탈퇴가 완료되었습니다.");
		
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);
	}

}
