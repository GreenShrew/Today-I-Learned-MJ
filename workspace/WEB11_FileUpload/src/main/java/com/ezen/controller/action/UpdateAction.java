package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.ProductDao;
import com.ezen.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("upload");
		
		String code = "";
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 20*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			ProductVO pvo = new ProductVO();
			// 전달된 모든 파라미터를 pvo에 저장하여 수정한다.
			code = multi.getParameter("code");
			pvo.setCode(Integer.parseInt(code));

			pvo.setName(multi.getParameter("name"));
			pvo.setPrice(Integer.parseInt(multi.getParameter("price")));
			pvo.setDescription(multi.getParameter("description"));
			if(multi.getFilesystemName("pictureurl") == null) {
				pvo.setPictureurl(multi.getParameter("oldPicture"));		// 사진을 변경하지 않는다면 이전 사진을 다시 넣는다.
			}else {
				pvo.setPictureurl(multi.getFilesystemName("pictureurl"));
			}
			
			ProductDao pdao = ProductDao.getInstance();
			pdao.updateProduct(pvo);
		}catch(Exception e) {
			System.out.println("파일 업로드 실패 : "+e);
		}
		String url = "product.do?command=productView&code="+code;
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
