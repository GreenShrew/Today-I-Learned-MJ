package com.ezen.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyDto;

public class boardViewWithoutCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// BoardViewAction 에서 코드를 긁어와서 조회수 증가시키는 부분만 빼면 된다!
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		
//		bdao.plusReadCount(num);		조회수 증가 생략!

		// 게시물을 읽어와서 request에 담고, 이를 boardView.jsp로 이동시키는 역할.
		BoardDto bdto = bdao.getBoard(num); // num값에 해당하는 게시글의 정보 긁어오기
		request.setAttribute("board", bdto);
		
		ArrayList<ReplyDto> list = bdao.selectReply(num);
		request.setAttribute("replyList", list);
		
		RequestDispatcher dp = request.getRequestDispatcher("board/boardView.jsp");
		dp.forward(request, response);
	}

}
