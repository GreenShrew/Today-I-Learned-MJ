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

public class OrderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// MyPageAction에서 코드를 복사해서 넣고 주석만 뺐다.
		// 필요한 기능은 똑같기 때문이다!
		
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if(mvo==null) {
			url = "shop.do?command=login_form";
		}else {
			OrderDao odao = OrderDao.getInstance();
			ArrayList<OrderVO> finalList = new ArrayList<OrderVO>();
			ArrayList<Integer> oseqList = odao.selectOseqOrderAll(mvo.getId());	// 여기가 바뀌었다.
			for(Integer i : oseqList) System.out.println(i);
			for(Integer oseq : oseqList) {
				ArrayList<OrderVO> orderListByOseq = odao.listOrderByOseq(oseq);
				OrderVO ovo = orderListByOseq.get(0);
				ovo.setPname(ovo.getPname() + " 포함 " + orderListByOseq.size() + " 건");
				int totalPrice = 0;
				for(OrderVO ovo1 : orderListByOseq) {
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				}
				ovo.setPrice2(totalPrice);
				finalList.add(ovo);
			}
			request.setAttribute("orderList", finalList);
			request.setAttribute("title", "총 주문 내역");		// 전달되는 값도 바뀌었다.
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
