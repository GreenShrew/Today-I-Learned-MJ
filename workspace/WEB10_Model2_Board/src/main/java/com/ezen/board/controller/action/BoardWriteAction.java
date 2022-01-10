package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto bdto = new BoardDto();
		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.insertBoard(bdto);
		
		// 여기서도 sendRedirect를 사용한다.
		// Forwarding을 사용하면 게시글을 작성하고 새로고침을 할 때마다 똑같은 게시글이 추가되는 현상이 나타난다!
		response.sendRedirect("board.do?command=main");
	}

}
