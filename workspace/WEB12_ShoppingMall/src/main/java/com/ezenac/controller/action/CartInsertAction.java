package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.CartDao;
import com.ezenac.dto.CartVO;
import com.ezenac.dto.MemberVO;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// cartVO에 전달 파라미터를 넣고, cart에 레코드를 추가한다.
		
		// 로그인 유저 확인 후, 아무도 로그인이 안 되어있다면 로그인 페이지로 이동
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "";
		if(mvo==null) {	// 로그인이 안 되어있는 상태
			url = "shop.do?command=loginForm";
		}else {
			// 로그인 유저의 아이디, 전달된 파라미터의 수량과 상품 번호를 CartVO에 넣고 추가 메소드를 호출
			CartVO cvo = new CartVO();
			cvo.setId(mvo.getId());	// 아이디는 위의 코드에서 session에서 얻어와서 mvo에 저장했다.
			cvo.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			CartDao cdao = CartDao.getInstance();
			cdao.insertCart(cvo);
			url = "shop.do?command=cartList";
			// insert 대상은 cart 테이블, select 대상은 cart_view 뷰
		}
		// 추가한 후에, 카트 리스트를 조회해서 cartList.jsp로 이동하도록 shop.do?command=cartList로 forwarding한다.
		response.sendRedirect(url);
		// forwarding으로 만들면 다음 페이지에서 새로고침 할 때마다 정보가 추가되어버린다.
	}

}
