package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.OrderDao;
import com.ezenac.dao.ProductDao;
import com.ezenac.dto.MemberVO;
import com.ezenac.dto.ProductVO;

public class OrderOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		int pseq = Integer.parseInt(request.getParameter("pesq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		// 로그인 조회
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url = "shop.do?command=loginForm";
		}else {
			
			// 결제 절차는 생략
			// ProductDao에 있는 getProduct()로 상품을 조회한다.
			ProductDao pdao = ProductDao.getInstance();
			ProductVO pvo = pdao.getProduct(pseq);
			
			// OrderDao 에 inserOrderOne 메소드를 만들어서 아이디와 상품 객체, 수량를 보내서 주문을 완료한다.
			OrderDao odao = OrderDao.getInstance();
			int oseq = odao.insertOrderOne(pvo, mvo.getId(), quantity);
			
			// oseq를 리턴받아 orderList.jsp로 가서 주문내역을 화면에 표시하도록 한다.
			url = "shop.do?command=orderList&oseq="+oseq;
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
