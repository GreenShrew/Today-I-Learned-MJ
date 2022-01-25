package com.ezenac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 할 일은 adminProductList로 돌아가는 것.
		
		String url = "shop.do?command=adminProductList";
		
		// 세션으로 로그인 확인
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
			// 파일 업로드를 위해 필요한것들
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath("product_images");
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			// 상품이 등록되는 코드
			ProductVO pvo = new ProductVO();
			pvo.setKind(multi.getParameter("kind"));
			pvo.setName(multi.getParameter("name"));
			pvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			pvo.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			pvo.setPrice3(Integer.parseInt(multi.getParameter("price3")));
			pvo.setContent(multi.getParameter("content"));
			pvo.setImage(multi.getFilesystemName("image"));
			
			AdminDao adao = AdminDao.getInstance();
			adao.insertProduct(pvo);
		}
		response.sendRedirect(url);
	}

}
