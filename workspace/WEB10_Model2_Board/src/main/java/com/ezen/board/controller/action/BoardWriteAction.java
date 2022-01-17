package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDto bdto = new BoardDto();
		
		// 파일이 저장될 서버 내의 경로(이미지의 실제 경로)를 얻는 동작이 필요하다.
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("images");

		MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		// request.getParameter로 넣게 되면 null값이 나온다!
		bdto.setUserid(multi.getParameter("userid"));
		bdto.setPass(multi.getParameter("pass"));
		bdto.setTitle(multi.getParameter("title"));
		bdto.setEmail(multi.getParameter("email"));
		bdto.setContent(multi.getParameter("content"));
		bdto.setImgfilename(multi.getFilesystemName("imgfilename"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.insertBoard(bdto);
		
		// 여기서도 sendRedirect를 사용한다.
		// Forwarding을 사용하면 게시글을 작성하고 새로고침을 할 때마다 똑같은 게시글이 추가되는 현상이 나타난다!
		response.sendRedirect("board.do?command=main");
	}

}
