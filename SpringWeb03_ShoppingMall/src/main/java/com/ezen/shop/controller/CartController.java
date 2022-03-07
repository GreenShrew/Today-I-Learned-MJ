package com.ezen.shop.controller;

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
import com.ezen.shop.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cs;
	
	@RequestMapping("cartInsert")
	public String cartInsert(HttpServletRequest request,	// 로그인 되어있는지 확인하기 위해 필요하다.
			@RequestParam("pseq") int pseq,
			@RequestParam("quantity") int quantity) {	// 매개변수가 여러개일땐 이렇게 쓴다.
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo==null) {
			return "member/login";
		}else {
			CartVO cvo = new CartVO();
			cvo.setUserid(mvo.getUserid());
			cvo.setPseq(pseq);
			cvo.setQuantity(quantity);
			
			cs.inserCart(cvo);
		}
		
		return "redirect:/cartList";
	}
	
	
	@RequestMapping("cartList")
	public ModelAndView cartList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo==null) {
			mav.setViewName("member/login");
		}else {
			List<CartVO> list = cs.listCart(mvo.getUserid());
			int totalPrice = 0;
			for(CartVO cvo : list) {
				totalPrice += cvo.getPrice2() * cvo.getQuantity();
			}
			// 조회하고 계산된 리스트와 총 금액을 mav에 넣고 cartList.jsp 로 이동.
			// 저장 이름은 cartList, totalPrice
			
			mav.addObject("totalPrice", totalPrice);
			mav.addObject("cartList", list);
			mav.setViewName("mypage/cartList");
		}
		
		return mav;
	}
	
	
	@RequestMapping("cartDelete")
	public String cartDelete(@RequestParam("cseq") String [] cseqArr) {
		// String[] cseqArr = request.getParameterValues("cseq");
		
		for(String cseq : cseqArr) {
			cs.deleteCart(cseq);
		}
		return "redirect:/cartList";
	}
}
