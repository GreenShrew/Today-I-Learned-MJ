package com.ezen.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.shop.dto.CartVO;
import com.ezen.shop.dto.MemberVO;
import com.ezen.shop.dto.OrderVO;
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
	
	
	@RequestMapping("/orderList")
	public ModelAndView orderList(@RequestParam("oseq") int oseq, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			mav.setViewName("member/login");
		}else {
			List<OrderVO> list = os.listOrderByOseq(oseq);	// 주문조회
			int totalPrice = 0;
			for(OrderVO ovo : list) {
				totalPrice = ovo.getPrice2() * ovo.getQuantity();
			}
			mav.addObject("orderList", list);
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("mypage/orderList");
		}
		
		return mav;
	}
	
	
	@RequestMapping("/orderOne")
	public String orderOne(HttpServletRequest request, 
			@RequestParam("pseq") int pseq, @RequestParam("quantity") int quantity) {
		int oseq=0;
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			return "member/login";
		}else {
			oseq = os.insertOrderOne(pseq, quantity, mvo.getUserid());
		}
		
		return "redirect:/orderList?oseq="+oseq;
	}
	
	
	@RequestMapping("/myPage")
	public ModelAndView myPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			mav.setViewName("member/login");
		}else {
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();	// mypage.jsp에 전달될 리스트
			
			// 1. 아이디로 진행중인 주문의 주문번호들을 조회한다.
			List<Integer> oseqList = os.selectSeqOrderIng(mvo.getUserid());
			
			// 2. 조회한 주문번호들의 각각의 주문 상품들을 조회한다.
			for(int oseq : oseqList) {
				List<OrderVO> orderListIng = os.listOrderByOseq(oseq);	// 주문번호 하나의 주문 상품들 리스트
				
				// 3. 리스트의 첫번째로 주문을 꺼내서, 이름을 "상품명 외 x건", 가격을 리스트 상품들의 가격 총합으로 변경
				OrderVO ovo = orderListIng.get(0);	// 첫번째 상품 꺼냄
				ovo.setPname(ovo.getPname() + " 포함 " + orderListIng.size() + " 건");	// 이름 변경
				int totalPrice = 0;
				for(OrderVO ovo1 : orderListIng) {
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
					ovo.setPrice2(totalPrice);	// 가격 변경
				}
				
				// 4. mypage.jsp에 전달할 리스트에 현재 ovo를 추가
				orderList.add(ovo);
			}
			mav.addObject("title", "진행중인 주문 내역");
			mav.addObject("orderList", orderList);
			mav.setViewName("mypage/mypage");
		}
		return mav;
	}
}
