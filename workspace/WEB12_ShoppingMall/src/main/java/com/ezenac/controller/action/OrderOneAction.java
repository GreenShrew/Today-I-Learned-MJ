package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pseq = Integer.parseInt(request.getParameter("pesq"));
		// 로그인 조회
		HttpSession session = request.getSession();
		
		// ProductoDao에 있는 getProduct()로 상품을 조회한다.
		
		// OrderDao 에 OrderInsertOne 메소드를 만들어서 아이디와 상품 객체를 보내서 주문을 완료한다.
		
		// oseq를 리턴받아 orderList.jsp로 가서 주문내역을 화면에 표시하도록 한다.
		
	}

}
