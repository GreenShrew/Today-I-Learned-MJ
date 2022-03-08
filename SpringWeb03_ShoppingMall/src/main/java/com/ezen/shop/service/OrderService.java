package com.ezen.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.OrderDao;
import com.ezen.shop.dto.CartVO;
import com.ezen.shop.dto.OrderVO;

@Service
public class OrderService {

	@Autowired
	OrderDao odao;

	public int insertOrder(List<CartVO> cartList, String userid) {
		odao.insertOrders(userid);	// orders 테이블에 레코드 추가
		
		int oseq = odao.lookupMaxOseq();		// 방금 orders 테이블에 추가한 주문의 주문번호를 조회한다.
		
		// 카트에 있는 각 상품들과 조회한 주문번호를 이용하여 order_detail 테이블에 상품들을 각각 추가한다.
		for(CartVO cvo : cartList) {
			odao.insertOrderDetail(cvo, oseq);
			odao.deleteCart(cvo.getCseq());	// 방금 추가한 주문에 해당되는 장바구니의 상품 삭제
		}
		return oseq;
	}

	public List<OrderVO> listOrderByOseq(int oseq) {
		
		return odao.listOrderByOseq(oseq);
	}

	public int insertOrderOne(int pseq, int quantity, String userid) {
		// 전달받은 id로 주문목록을 가져와서
		odao.insertOrders(userid);
		// 그 주문목록중 가장 최근 주문번호를 선택
		int oseq = odao.lookupMaxOseq();
		// 그 주문번호를 이용해 물건 하나만 저장하고
		odao.insertOrderDetailOne(pseq, quantity, oseq);
		// 사용한 주문번호를 보내서 화면에 해당 주문이 내역으로 나오도록 만든다.
		return oseq;
	}

	public List<Integer> selectSeqOrderIng(String userid) {
		return odao.selectSeqOrderIng(userid);
	}
}
