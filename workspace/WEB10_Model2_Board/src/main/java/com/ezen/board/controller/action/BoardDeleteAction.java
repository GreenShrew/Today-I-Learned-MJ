package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// checkSuccess에서 지울 게시물의 num값을 받는다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteBoard(num);
		
		String url = "board.do?command=main";		// 게시글 지우고 나면 main 페이지로 이동시킨다.
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
