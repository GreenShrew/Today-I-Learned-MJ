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

import com.ezen.spm17.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService os;
	
	
	@RequestMapping(value="/orderInsert")
	public String orderInsert(HttpServletRequest request) {
		int oseq = 0;
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("oseq", 0);		// OUT 변수로 적용되어서 돌아올, 방금 주문한 주문의 주문번호를 담는다.
			
			os.insertOrder(paramMap);
			// insertOrder에서 해야할 작업들!
			// 아이디로 카트검색
			// 검색내용으로 orders와 order_detail 테이블에 레코드 추가
			// oseq에 주문번호를 넣어 갖고 되돌아온다.
			
			oseq = Integer.parseInt(paramMap.get("oseq").toString());	// String 형으로 바꿔서 integer 형으로 바꾸었다.
			// 자꾸 바로 int 로 바꾸면 값이 안 들어가...
			System.out.println(oseq);		// 확인용
		}
		// 전달받은 oseq를 가지고 orderList인 request로 간다
		return "redirect:/orderList?oseq="+oseq;
	}
	
	
	@RequestMapping(value="/orderList")
	public ModelAndView orderList(HttpServletRequest request, Model model,
			@RequestParam("oseq") int oseq) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mav.setViewName("member/login");
			return mav;
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("oseq", oseq);
			paramMap.put("ref_cursor", null);
			
			os.listOrderByOseq(paramMap);		// 주문번호에 의한 주문 목록 조회
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			mav.addObject("orderList", list);
			
			int totalPrice = 0;
			for(HashMap<String, Object> ovo : list) {		// 리스트의 내용으로 총 금액 계산
				totalPrice += Integer.parseInt(ovo.get("QUANTITY").toString())
									* Integer.parseInt(ovo.get("PRICE2").toString());
			}
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("mypage/orderList");
		}
		return mav;
	}
	
}
