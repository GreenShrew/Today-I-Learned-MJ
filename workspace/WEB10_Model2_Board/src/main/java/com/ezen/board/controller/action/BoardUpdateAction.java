package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 값을을 bto에 넣고
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();
		
		// 파일이 저장될 서버 내의 경로(이미지의 실제 경로)를 얻는 동작
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("images");
		
		MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());

		bdto.setUserid(multi.getParameter("userid"));
		bdto.setPass(multi.getParameter("pass"));
		bdto.setEmail(multi.getParameter("email"));
		bdto.setTitle(multi.getParameter("title"));
		bdto.setContent(multi.getParameter("content"));
		int num = Integer.parseInt(multi.getParameter("num"));	// 이걸 한번 더 써야해서 이렇게 만들어둔다.
		bdto.setNum(num);
		
		String filename = multi.getFilesystemName("imgfilename");
		if(filename==null) {
			filename = multi.getParameter("oldfilename");
		}
		bdto.setImgfilename(filename);
		
		// bao의 메소드를 이용해서 table 수정을 하고
		bdao.updateBoard(bdto);
		
		// 게시글로 돌아가지만 조회수가 올라가지 않도록 만든 클래스로 페이지를 넘긴다.
		String url = "board.do?command=boardViewWithoutCount&num="+num;	// 보내는 num 값의 게시글로 되돌아감.
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
