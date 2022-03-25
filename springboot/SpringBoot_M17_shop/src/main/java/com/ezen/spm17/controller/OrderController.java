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
	
	
	@RequestMapping(value="/myPage")
	public ModelAndView mypage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mav.setViewName("member/login");
			return mav;
		}else {
			// 최종 mypage.jsp에 전달될 리스트
			ArrayList<HashMap<String, Object>> finalList
				= new ArrayList<HashMap<String, Object>>();
			
			// 현재 로그인 중인 유저의 진행중인 주문번호 리스트 조회
			HashMap<String, Object> paramMap1 = new HashMap<String, Object>();
			paramMap1.put("id", loginUser.get("USERID"));
			paramMap1.put("ref_cursor", null);
			os.listOrderByIdIng(paramMap1);	// 현재 로그인 유저의 진행중인 주문들의 "주문번호들" 조회
			
			ArrayList<HashMap<String, Object>> oseqList
				= (ArrayList<HashMap<String, Object>>) paramMap1.get("ref_cursor");
			
			// 주문번호별 주문내역을 조회
			for(HashMap<String, Object> result : oseqList) {
				int oseq = Integer.parseInt(result.get("OSEQ").toString());
				HashMap<String, Object> paramMap2 = new HashMap<String, Object>();
				paramMap2.put("oseq", oseq);
				paramMap2.put("ref_cursor", null);
				os.listOrderByOseq(paramMap2);
				
				ArrayList<HashMap<String, Object>> orderListByOseq
					= (ArrayList<HashMap<String, Object>>) paramMap2.get("ref_cursor");
				
				HashMap<String, Object> orderFirst = orderListByOseq.get(0);
				orderFirst.put("PNAME", (String)orderFirst.get("PNAME") + "포함 " + orderListByOseq.size() + " 건");
				// 첫번째 상품의 상품명을 "XX 포함 X건" 이라고 수정
				
				int totalPrice = 0;
				for(HashMap<String, Object> order : orderListByOseq) {
					totalPrice += Integer.parseInt(order.get("QUANTITY").toString())
										* Integer.parseInt(order.get("PRICE2").toString());
				}
				orderFirst.put("PRICE2", totalPrice);	// 추출한 첫번째 상품의 가격을 총 가격으로 수정
				// 주문 번호별 대표 상품(첫번째 상품)을 별도의 ArrayList의 객체 finalList로 모아서 modelandview에 저장한다!
				finalList.add(orderFirst);
			}
			
			mav.addObject("orderList", finalList);
		}
		
		mav.addObject("title", "진행중인 주문내역");
		mav.setViewName("mypage/mypage");
		return mav;
	}
	
	
	@RequestMapping(value="/orderAll")
	public ModelAndView orderAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			mav.setViewName("member/login");
			return mav;
		}else {
			// 최종 mypage.jsp에 전달될 리스트
			ArrayList<HashMap<String, Object>> finalList
				= new ArrayList<HashMap<String, Object>>();
			
			// 현재 로그인 중인 유저의 진행중인 주문번호 리스트 조회
			HashMap<String, Object> paramMap1 = new HashMap<String, Object>();
			paramMap1.put("id", loginUser.get("USERID"));
			paramMap1.put("ref_cursor", null);
			os.listOrderByIdAll(paramMap1);	// 현재 로그인 유저의 모든 주문들의 "주문번호들" 조회
			
			ArrayList<HashMap<String, Object>> oseqList
				= (ArrayList<HashMap<String, Object>>) paramMap1.get("ref_cursor");
			
			// 주문번호별 주문내역을 조회
			for(HashMap<String, Object> result : oseqList) {
				int oseq = Integer.parseInt(result.get("OSEQ").toString());
				HashMap<String, Object> paramMap2 = new HashMap<String, Object>();
				paramMap2.put("oseq", oseq);
				paramMap2.put("ref_cursor", null);
				os.listOrderByOseq(paramMap2);
				
				ArrayList<HashMap<String, Object>> orderListByOseq
					= (ArrayList<HashMap<String, Object>>) paramMap2.get("ref_cursor");
				
				HashMap<String, Object> orderFirst = orderListByOseq.get(0);
				orderFirst.put("PNAME", (String)orderFirst.get("PNAME") + "포함 " + orderListByOseq.size() + " 건");
				// 첫번째 상품의 상품명을 "XX 포함 X건" 이라고 수정
				
				int totalPrice = 0;
				for(HashMap<String, Object> order : orderListByOseq) {
					totalPrice += Integer.parseInt(order.get("QUANTITY").toString())
										* Integer.parseInt(order.get("PRICE2").toString());
				}
				orderFirst.put("PRICE2", totalPrice);	// 추출한 첫번째 상품의 가격을 총 가격으로 수정
				// 주문 번호별 대표 상품(첫번째 상품)을 별도의 ArrayList의 객체 finalList로 모아서 modelandview에 저장한다!
				finalList.add(orderFirst);
			}
			
			mav.addObject("orderList", finalList);
		}
		
		mav.addObject("title", "전체 주문내역");
		mav.setViewName("mypage/mypage");
		return mav;
	}
	
	
	@RequestMapping(value="/orderDetail")
	public ModelAndView orderAll(HttpServletRequest request, Model model,
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
			os.listOrderByOseq(paramMap);
			
			ArrayList<HashMap<String, Object>> orderListByOseq
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			int totalPrice = 0;
			for(HashMap<String, Object> order : orderListByOseq) {
				totalPrice += Integer.parseInt(order.get("QUANTITY").toString())
									* Integer.parseInt(order.get("PRICE2").toString());
			}

			mav.addObject("totalPrice", totalPrice);
			mav.addObject("orderList", orderListByOseq);
			mav.addObject("orderDetail", orderListByOseq.get(0));
			mav.setViewName("mypage/orderDetail");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/orderInsertOne")
	public String orderInsertOne(HttpServletRequest request,
			@RequestParam("pseq") int pseq,
			@RequestParam("quantity") int quantity) {
		int oseq = 0;
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		}else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("pseq", pseq);	// 주문할 상품의 상품 번호
			paramMap.put("quantity", quantity);	// 주문할 상품의 수량
			paramMap.put("oseq", 0);		// OUT 변수로 적용되어서 돌아올, 방금 주문한 주문의 주문번호를 담는다.
			
			os.insertOrderOne(paramMap);
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
}
