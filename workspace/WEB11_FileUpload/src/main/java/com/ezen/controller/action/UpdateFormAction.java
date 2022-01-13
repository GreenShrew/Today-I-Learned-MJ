package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDao;
import com.ezen.dto.ProductVO;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 상품 번호로 상품을 조회하고, request에 담아서 updateForm.jsp로 이동한다.
		String code = request.getParameter("code");	// 이전 페이지에서 ${product.code} 로 전달되어진 code를 저장
		
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProduct(code);		// 이전에 만들었던 메소드 재활용
		
		request.setAttribute("product", pvo);		// 조회한 내용이 담긴 pvo를 product라는 이름으로 request에 담는다
		
		RequestDispatcher rd = request.getRequestDispatcher("product/updateForm.jsp");
		rd.forward(request, response);
	}

}
