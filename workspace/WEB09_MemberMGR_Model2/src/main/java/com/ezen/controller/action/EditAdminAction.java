package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class EditAdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// main에서 userid가 같이 날아온다.
		
		
		String userid = request.getParameter("userid");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);		// 기존에 만들어두었던 회원 조회 메소드
		
		if(mdto.getAdmin() == 1) {
			mdao.editAdmin(userid, 0);	// 1이면 0으로
		}else {
			mdao.editAdmin(userid, 1);	// 0이면 1로
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("member.do?command=main");
		dp.forward(request, response);
	}

}
