package com.ezen.spm17.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.spm17.dao.IOrderDao;

@Service
public class OrderService {

	@Autowired
	IOrderDao odao;

	@Transactional(rollbackFor = Exception.class)
	public void insertOrder(HashMap<String, Object> paramMap) {
		odao.insertOrder(paramMap);
	}

	public void listOrderByOseq(HashMap<String, Object> paramMap) {
		odao.listOrderByOseq(paramMap);
	}

	// 조회는 @Transactional(rollbackFor = Exception.class) 안 붙인다!
	public void listOrderByIdIng(HashMap<String, Object> paramMap) {
		odao.listOrderByIdIng(paramMap);
	}

	public void listOrderByIdAll(HashMap<String, Object> paramMap) {
		odao.listOrderByIdAll(paramMap);
	}

	public void insertOrderOne(HashMap<String, Object> paramMap) {
		odao.insertOrderOne(paramMap);
	}
}
