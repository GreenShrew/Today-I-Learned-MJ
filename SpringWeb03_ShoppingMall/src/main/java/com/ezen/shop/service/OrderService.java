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
		odao.insertOrders( userid );  // orders 테이블에 레코드 추가
		
		int oseq = odao.lookupMaxOseq(); // 방금  orders 테이블에 추가한 주문의 주문번호를 조회합니다
		
		// 카트에 있는 각 상품들과 조회한 주문번호를 이용해서  order_detail  테이블에 상품들을 각각 추가합니다
		for( CartVO cvo : cartList ) {
			odao.insertOrderDetail( cvo, oseq);
			odao.deleteCart( cvo.getCseq() );
		}
		return oseq;
	}

	public List<OrderVO> listOrderByOseq(int oseq) {
		return odao.listOrderByOseq(oseq);
	}

	public int insertOrderOne(int pseq, int quantity, String userid) {
		odao.insertOrders( userid );  
		int oseq = odao.lookupMaxOseq(); 		
		odao.insertOrderDetailOne( pseq, quantity, oseq);
		return oseq;
	}

	public List<Integer> selectSeqOrderIng(String userid) {
		return odao.selectSeqOrderIng(userid);
	}

	public List<Integer> oseqListAll(String userid) {
		return odao.oseqListAll(userid);
	}
}







