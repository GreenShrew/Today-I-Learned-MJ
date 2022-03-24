package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cs;
	
	
	@RequestMapping(value="/cartInsert")
	public String cartInsert(HttpServletRequest request, Model model,
			@RequestParam("pseq") int pseq,
			@RequestParam("quantity") int quantity
			) {
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			// cart 테이블에는 userid가 아니라 id가 필드명이다.
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("pseq", pseq);
			paramMap.put("quantity", quantity);
			
			cs.insertCart(paramMap);
			
			return "redirect:/cartList";
		}
	}
	
	
	@RequestMapping(value="/cartList")
	public ModelAndView cartList(HttpServletRequest request, Model model) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mav.setViewName("member/login");
			return mav;
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("ref_cursor", null);
			cs.listCart(paramMap);
			
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			mav.addObject("cartList", list);
			
			int totalPrice = 0;
			for(HashMap<String, Object> cart : list) {
				totalPrice += Integer.parseInt(cart.get("QUANTITY").toString())
									* Integer.parseInt(cart.get("PRICE2").toString());
			}
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("mypage/cartList");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/cartDelete")
	public String cartDelete(HttpServletRequest request,
			@RequestParam("cseq") String[] cseqArr) {		// 체크박스의 value 값들을 cseqArr이라는 배열에 담았다.
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		for(String cseq : cseqArr) {	// cseqArr에 담긴 체크박스 번호들을 한번씩 넣어서 삭제.
			paramMap.put("cseq", cseq);
			cs.deleteCart(paramMap);
		}
		return "redirect:/cartList";
	}
}
