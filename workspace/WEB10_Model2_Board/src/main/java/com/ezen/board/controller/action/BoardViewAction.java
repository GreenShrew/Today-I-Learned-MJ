package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시물의 조회수를 1 증가시키는 역할.
		
		// 게시물을 읽어와서 request에 담고, 이를 boardView.jsp로 이동시키는 역할.
	}

}
