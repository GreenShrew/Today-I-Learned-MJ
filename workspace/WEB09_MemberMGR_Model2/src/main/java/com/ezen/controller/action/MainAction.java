package com.ezen.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기서 회원의 정보를 전부 긁어서 main.jsp 페이지로 Forwarding한다.
		// 그럼 main 페이지에서는 해당 데이터를 바탕으로 화면에 전체 회원의 목록을 나열한다.
		
		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberDto> list = mdao.selectMember();	// 리스트 형태로 전부 긁어와서
		
		request.setAttribute("memberList", list);	// memberList라는 이름으로 list를 저장
		
		RequestDispatcher dp = request.getRequestDispatcher("main.jsp");
		dp.forward(request, response);	// 데이터를 가지고 main.jsp로 이동
		
		
		
	}

}
