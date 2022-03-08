package com.ezen.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.shop.dto.CartVO;
import com.ezen.shop.dto.MemberVO;
import com.ezen.shop.service.CartService;
import com.ezen.shop.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService os;
	
	@Autowired
	CartService cs;	// 필요할 일이 있으므로 써둔다. 카트 리스트를 가져오거나...
	
	@RequestMapping("/orderInsert")
	public String orderinsert(HttpServletRequest request) {
		int oseq = 0;

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			return "redirect:/login";
		}else {
			List<CartVO> cartList = cs.listCart(mvo.getUserid());
			oseq = os.insertOrder(cartList, mvo.getUserid());
		}
		
		// 방금 막 주문한 주문번호로 리스트 조회후 화면에 표시하러 이동한다.
		return "redirect:/orderList?oseq="+oseq;
	}
}
