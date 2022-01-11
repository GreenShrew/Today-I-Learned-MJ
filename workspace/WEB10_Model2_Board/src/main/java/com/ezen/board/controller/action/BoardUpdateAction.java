package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 값을을 bto에 넣고
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();

		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setContent(request.getParameter("content"));
		int num = Integer.parseInt(request.getParameter("num"));	// 이걸 한번 더 써야해서 이렇게 만들어둔다.
		bdto.setNum(num);
		
		// bao의 메소드를 이용해서 table 수정을 하고
		bdao.updateBoard(bdto);
		
		// 게시글로 돌아가지만 조회수가 올라가지 않도록 만든 클래스로 페이지를 넘긴다.
		String url = "board.do?command=boardViewWithoutCount&num="+num;	// 보내는 num 값의 게시글로 되돌아감.
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
