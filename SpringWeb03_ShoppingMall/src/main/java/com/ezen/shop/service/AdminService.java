package com.ezen.shop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.AdminDao;
import com.ezen.shop.dto.OrderVO;
import com.ezen.shop.dto.Paging;
import com.ezen.shop.dto.ProductVO;

@Service
public class AdminService {

	@Autowired
	AdminDao adao;

	public int workerCheck(String workId, String workPwd) {
		return adao.workerCheck(workId, workPwd);
	}

	public HashMap<String, Object> productList( int page, String key ) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Paging paging = new Paging();
		paging.setPage(page);
		
		int count = adao.getAllCount("product"  , "name" , key);
		paging.setTotalCount( count );
		
		List<ProductVO> list = adao.productList(paging , key);
		
		resultMap.put("productList", list);
		resultMap.put("paging", paging);
		
		return resultMap;
	}

	public void insertProduct(ProductVO pvo) {
		adao.insertProduct(pvo);		
	}

	public void updateProduct(ProductVO pvo) {
		adao.updateProduct(pvo);		
	}

	public HashMap<String, Object> orderList(int page, String key) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Paging paging = new Paging();
		paging.setPage(page);
		
		int count = adao.getAllCount("order_view"  , "mname" , key);
		paging.setTotalCount( count );
		
		List<OrderVO> list = adao.orderList(paging , key);
		
		resultMap.put("orderList", list);
		resultMap.put("paging", paging);
		
		return resultMap;
	}

	public void updateOrderResult(int odseq) {
		adao.updateOrderResult(odseq);		
	}
}














