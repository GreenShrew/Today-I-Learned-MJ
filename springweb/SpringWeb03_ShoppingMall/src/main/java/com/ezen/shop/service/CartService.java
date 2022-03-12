package com.ezen.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.CartDao;
import com.ezen.shop.dto.CartVO;

@Service
public class CartService {

	@Autowired
	CartDao cdao;

	public void insertCart(CartVO cvo) {
		cdao.insert(cvo);		
	}

	public List<CartVO> listCart(String userid) {
		return cdao.listCart(userid);
	}

	public void deleteCart(String cseq) {
		cdao.delete(cseq);
		
	}
}
