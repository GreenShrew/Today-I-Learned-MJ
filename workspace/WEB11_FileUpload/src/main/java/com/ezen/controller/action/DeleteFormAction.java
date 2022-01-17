package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDao;
import com.ezen.dto.ProductVO;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달되는 상품을 삭제하고, productList.jsp로 이동한다.
		String code = request.getParameter("code");
		
		ProductDao pdao = ProductDao.getInstance();
		pdao.deleteProduct(code);
		
		RequestDispatcher rd = request.getRequestDispatcher("product.do?command=index");
		rd.forward(request, response);
	}

}
