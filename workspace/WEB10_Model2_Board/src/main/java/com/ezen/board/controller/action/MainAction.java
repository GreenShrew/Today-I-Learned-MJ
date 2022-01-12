package com.ezen.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.Paging;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao bdao = BoardDao.getInstance();
		// ArrayList<BoardDto> list = bdao.selectBoard(); 조회를 여기서 하면 안된다. 여기서 조회하면 게시글을 전부 조회해서 list에 저장한다!
		
		Paging paging = new Paging();
		
		int page = 1;		// 첫번째 볼 때는 페이지는 1이다!
		
		// 2페이지를 클릭했을 때 -> board.do?command=main&page=2
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		paging.setPage(page);
		
		int count = bdao.getAllCount();
		// setTotalCount 메소드 안에는 paging() 메소드 호출 명령이 같이 들어가있어 멤버변수들의 계산도 동시에 일어난다!	
		paging.setTotalCount(count);		// 레코드 총 갯수 셋팅 + 각 멤버변수 값 계산
		
		// 이 자리에 위치시키고 전달인수로 paging을 보낸다!
		// paging에는 몇번부터 몇번 게시물까지 보겠다! 라는 정보가 담겨있다. 이를 보내서 원하는 게시물만 긁어오도록 만든다.
		ArrayList<BoardDto> list = bdao.selectBoard(paging);
		
		for(BoardDto bdto : list) {
			int cnt = bdao.getReplycnt(bdto.getNum());		// 게시물 번호로 댓글의 갯수를 세고 와서
			bdto.setReplycnt(cnt);		// 그 갯수를 현재 게시물의 댓글 갯수로 저장해준다.
		}
		
		request.setAttribute("boardList" , list);
		request.setAttribute("paging", paging);
		
		RequestDispatcher dp = request.getRequestDispatcher("main.jsp");
		dp.forward(request, response);

	}

}
