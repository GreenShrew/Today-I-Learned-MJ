package com.ezen.spm17.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			
			return "";
		}
		
		
	}
}
