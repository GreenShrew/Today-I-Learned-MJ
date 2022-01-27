package com.ezenac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.CartDao;
import com.ezenac.dao.MemberDao;
import com.ezenac.dao.OrderDao;
import com.ezenac.dto.MemberVO;
import com.ezenac.dto.OrderVO;

public class WithrawalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/completeWithdrawal.jsp";	// '그동안 이용해주셔서 감사합니다' 페이지로 이동
		
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="shop.do?command=index";
		}else {
			// 멤버테이블의 useyn을 'x' 로 변경
			MemberDao mdao = MemberDao.getInstance();
			mdao.updateUseyn(mvo.getId());
			
			// cart 테이블의 현재 아이디로 추가했던 레코드 삭제
			CartDao cdao = CartDao.getInstance();
			cdao.deleteCart(mvo.getId());
			
			// orders 테이블에서 현재 아이디로 추가한 주문번호 목록 조회
			OrderDao odao = OrderDao.getInstance();
			ArrayList<Integer> oseqList = odao.selectOseqOrderAll(mvo.getId());
			
			// orders 테이블의 관련 레코드 삭제 (oseq로 삭제) - 조회된 주문번호로 반복실행
			// order_detail 테이블의 관련 레코드 삭제 (oseq로 삭제) - 조회된 주문번호로 반복실행
			for(Integer oseq : oseqList) {
				odao.deleteOrders(oseq);
				odao.deleteOrder_detail(oseq);
			}
			// 로그아웃 - 세션에 로그인 정보 삭제
			session.removeAttribute("loginUser");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
