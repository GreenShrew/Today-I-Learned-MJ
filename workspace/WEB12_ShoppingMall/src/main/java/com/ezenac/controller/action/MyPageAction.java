package com.ezenac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.OrderDao;
import com.ezenac.dto.MemberVO;
import com.ezenac.dto.OrderVO;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if(mvo==null) {	// 유저가 로그인되어있지 않을 경우
			url = "shop.do?command=login_form";
		}else {
			OrderDao odao = OrderDao.getInstance();
			
			// 화면에 표시될 리스트 생성
			ArrayList<OrderVO> finalList = new ArrayList<OrderVO>();	// 아래에서 언급한 별도의 리스트, mypage.jsp에 전달될 리스트
			// (finalList.get(0).name : "XXXX 외 2건") <- 이렇게 만들 것이다.
			
			// 진행중인 주문 내역
			// 현재 로그인한 사용자의 아직 배송되지 않은 주문내역이 보여진다.
			// 예를 들어, 한번에 3개의 상품씩 4회에 걸쳐서 주문한 상태라면, 그리고 그 주문들이 하나도 배송이 안된 상태(배송전) 이라면
			// 진행중인 주문 내역은 네줄이 표시된다.(주문 건별 표시)
			// 표시 내용은 주문 건별 대표상품의 이름을 이용하여, 슬리퍼 포함 3개 혹은 겨울용부츠 외 2개 ... 등등의 총 네줄이 표시된다.
			// 그리고 각 행에는 상세보기 버튼이 있어 클릭하면 그 주문에 속한 세개의 상품을 볼 수 있다.
			
			// 이를 위해서 가장 먼저 필요한 사항은 주문 번호들이다.
			// order_view 에서 주문자 아이디로 검색하고, result가 1인 주문들을 검색해서, 주문번호들을 조회한다.
			// 위의 예를 든 상태라면 주문번호들이 다음과 같다.		22 22 22, 24 24 24, 26 26 26, 27 27 27	<- 조회된 주문 번호들이다.
			// 정작 필요한 정보는 22, 24, 26, 27이므로, 조회할때 distinct 키워드를 이용하여 중복을 제거하여 조회한다.
			// select distinct oseq from order_view where id=? and result='1'	이런식으로 조회

			ArrayList<Integer> oseqList = odao.selectOseqOrderIng(mvo.getId());	// 주문번호 리스트, 중복을 없앤 검색
			for(Integer i : oseqList) System.out.println(i);	// 조회가 잘 되는지 확인용..나중에 주석처리
			
			// 주문번호들로 반복실행을 하면 주문 번호별로 상품을 다시 조회해서 중복되는 셋의 상품이었다면 그 가격의 총 금액을 계산하고,
			// 첫번쨰 상품에 저장한다. 상품 이름도, 대표상품 이름 외 2건이라고 바꾸어준다.
			// 그 대표상품을 최종화면에 표시될 리스트에 따로 담는다.
			
			// 22번 주문의 3개의 상품에서 첫번째 상품의 상품이름을 "상품이름 외 2건"으로 변결
			// 3개의 가격을 합산한 금액을 22번 상품의 price2에 저장
			// 그 상품을 별도의 리스트에 저장한다.
			
			for(Integer oseq : oseqList) {	// 리스트에 담긴 주문 번호들을 하나씩 꺼내서 반복 실행
				ArrayList<OrderVO> orderListByOseq = odao.listOrderByOseq(oseq);
				// 순서대로 했을 때 첫번쨰 상품을 꺼낸다.
				OrderVO ovo = orderListByOseq.get(0);
				// 꺼낸 상품의 이름을 "대표상품명 포함 X 건" 으로 바꾼다.
				ovo.setPname(ovo.getPname() + " 포함 " + orderListByOseq.size() + " 건");
				
				// 총 금액을 계산
				int totalPrice = 0;
				for(OrderVO ovo1 : orderListByOseq) {
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				}
				
				// 꺼낸 상품에 총액도 방금 계산한 금액으로 변경한다.
				ovo.setPrice2(totalPrice);
				
				// 그리고 ovo를 finalList에 담는다.
				finalList.add(ovo);
			}
			
			// 리퀘스트에 담기는 리스트는 위에서 언급한 별도의 리스트(각 대표상품이 담겨있는)를 저장한다.
			request.setAttribute("orderList", finalList);
			request.setAttribute("title", "진행 중인 주문 내역");	// 이걸 왜 넣는지는 mypage.jsp 할때 나온다.
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
