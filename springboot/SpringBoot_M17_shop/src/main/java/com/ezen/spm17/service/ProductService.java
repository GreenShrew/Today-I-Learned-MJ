package com.ezen.spm17.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spm17.dao.IProductDao;

@Service
public class ProductService {

	@Autowired
	IProductDao pdao;

	public void getBestNewProduct(HashMap<String, Object> paramMap) {
		pdao.getBestNewProduct(paramMap);
	}
}
