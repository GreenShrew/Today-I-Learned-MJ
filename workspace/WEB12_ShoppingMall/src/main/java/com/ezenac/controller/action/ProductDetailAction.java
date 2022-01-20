package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.ProductDao;
import com.ezenac.dto.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 상품번호로 상품 내역을 조회한다.
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProduct(pseq);	// 상품번호로 상품 하나의 정보를 가져온다.
		
		// 조회된 상품 정보를 request에 담고, productDetail.jsp로 이동시킨다.
		request.setAttribute("productVO", pvo);
//		RequestDispatcher dp = request.getRequestDispatcher("product/productDetail.jsp");
//		dp.forward(request, response);
		// 이제 이런식으로 1줄로 줄여쓰자.
		request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);
	}

}
