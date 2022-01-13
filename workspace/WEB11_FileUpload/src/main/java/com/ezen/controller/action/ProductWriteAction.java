package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.ProductDao;
import com.ezen.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 현재 작성 영역은 Servlet이 아니라 Java 클래스에서 request를 전달받아 진행되는 곳이므로,
		HttpSession session = request.getSession();
		// request에서 세션을 추출한 후 session.getServletContext()를 사용해야 사용 가능하다.
		// ServletContext context = getServletContext();		Servlet 파일이라면 그냥 이렇게 써도 된다.
		ServletContext context = session.getServletContext();	// 사진 파일을 저장하기 위한 경로를 만들기 위해
		String path = context.getRealPath("upload");	// 업로드된 사진이 저장될 폴더의 이름(깊숙한 곳에 있는 그 폴더)
		
		ProductVO pvo = new ProductVO();
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			pvo.setName(multi.getParameter("name"));
			pvo.setPrice(Integer.parseInt(multi.getParameter("price")));
			pvo.setDescription(multi.getParameter("description"));
			pvo.setPictureurl(multi.getFilesystemName("pictureurl"));		// 파일이 저장된 경로
			
		} catch(Exception e){
			System.out.println("파일 업로드 실패 : " + e);
		}
		ProductDao pdao = ProductDao.getInstance();
		pdao.insertProduct(pvo);
		response.sendRedirect("product.do?command=index");	// 추가 끝났으면 다시 처음 페이지로 이동
		
	}

}
