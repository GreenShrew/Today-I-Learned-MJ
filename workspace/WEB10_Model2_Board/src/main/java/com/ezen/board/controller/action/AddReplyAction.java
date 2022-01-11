package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.ReplyDto;

public class AddReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReplyDto rdto = new ReplyDto();
		
		// 댓글 추가후 돌아갈 게시물 번호 저장
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		// 아이디, 내용, 게시물 번호를 rdto에 저장
		rdto.setUserid(request.getParameter("userid"));
		rdto.setContent(request.getParameter("reply"));
		rdto.setBoardnum(boardnum);
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.insertReply(rdto);
		
		// 똑같은 댓글을 계속해서 달지 않고 조회수 증가 없이 게시글로 돌아감.
		response.sendRedirect("board.do?command=boardViewWithoutCount&num="+boardnum);
	}

}
