package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.CartDao;

public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니에서의 체크박스 내용이 여기로 넘어왔다!
		// 체크된 값들은 배열의 형태로 넘어오기 때문에 배열로 받아야한다!
		String [] cseqArr = request.getParameterValues("cseq");
		
		CartDao cdao = CartDao.getInstance();
		
		for(String cseq : cseqArr) {	// 한꺼번에 삭제하는게 아니라 cseqArr의 내용을 하나하나 집어넣으며 하나씩 삭제한다.
			cdao.deleteCart(Integer.parseInt(cseq));		// 삭제할 상품의 번호 전송
		}
		response.sendRedirect("shop.do?command=cartList");	// 포워딩하면 문제가 생길 것 같아 sendRedirect 이용.
	}

}
