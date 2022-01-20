package com.ezenac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.ProductDao;
import com.ezenac.dto.ProductVO;

public class CategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전달된 파라미터 kind 값으로 검색 조회한 리스트를 리퀘스트에 담고 productKind.jsp로 이동
		String kind = request.getParameter("kind");
		ProductDao pdao = ProductDao.getInstance();
		ArrayList<ProductVO> list = pdao.selectKindProductList(kind);
		request.setAttribute("productKindList", list);
		String url="product/productKind.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
