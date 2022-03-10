package com.ezen.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.ProductDao;
import com.ezen.shop.dto.ProductVO;

@Service
public class ProductService {

	@Autowired
	ProductDao pdao;

	public List<ProductVO> getNewList() {
		List<ProductVO> list = pdao.getNewList();
		return list;
	}

	public List<ProductVO> getBestList() {
		List<ProductVO> list = pdao.getBestList();
		return list;
	}

	public List<ProductVO> getKindList(String kind) {
		return pdao.getKindList( kind );
	}

	public ProductVO getProduct(int pseq) {
		return pdao.getProduct(pseq);
	}
}














