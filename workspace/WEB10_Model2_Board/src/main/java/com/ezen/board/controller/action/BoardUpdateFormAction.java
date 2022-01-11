package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 게시물 번호로 게시물을 조회한 후 request에 담아서 게시물 수정 폼으로 이동
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = bdao.getBoard(num);
		
		request.setAttribute("board", bdto);
		RequestDispatcher dp = request.getRequestDispatcher("board/boardUpdate.jsp");
		dp.forward(request, response);
	}

}
