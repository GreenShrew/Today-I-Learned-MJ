package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;

public class DeleteReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String replynum = request.getParameter("replynum");	
		String boardnum = request.getParameter("boardnum");

		// 해당 댓글 삭제 후
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteReply(replynum);
		
		// 전달받은 게시물 번호로 돌아갑니다.
		String url = "board.do?command=boardViewWithoutCount&num=" + boardnum;
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
