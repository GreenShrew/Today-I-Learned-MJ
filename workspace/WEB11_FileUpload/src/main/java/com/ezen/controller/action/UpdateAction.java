package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("upload");
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 20*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			ProductVO pvo = new ProductVO();
			// 전달된 모든 파라미터를 pvo에 저장하여 수정한다.
			
		}catch(Exception e) {
			System.out.println("파일 업로드 실패 : "+e);
		}
		
	}

}
