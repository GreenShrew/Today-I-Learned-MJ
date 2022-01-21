package com.ezenac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.OrderDao;
import com.ezenac.dto.MemberVO;
import com.ezenac.dto.OrderVO;

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderList.jsp";
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url = "shop.do?command=loginForm";
		}else {
			OrderDao odao = OrderDao.getInstance();
			// order_view 에서 주문번호와 로그인 아이디로 주문을 검색한다.
			ArrayList<OrderVO> list = odao.listOrderByOseq(oseq);
			int totalPrice = 0;
			for(OrderVO ovo : list) {	// 조회된 주문의 총 결제금액 계산
				totalPrice += ovo.getPrice2() * ovo.getQuantity();
			// 리퀘스트에 저장
				request.setAttribute("orderList", list);
				request.setAttribute("totalPrice", totalPrice);
			}
			request.getRequestDispatcher(url).forward(request, response);		
		}
	}

}
