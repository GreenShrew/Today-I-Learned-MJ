package com.ezen.spm17.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spm17.dao.IAdminDao;

@Service
public class AdminService {

	@Autowired
	IAdminDao adao;

	public void getAdmin(HashMap<String, Object> paramMap) {
		adao.getAdmin(paramMap);
	}

	public void getAllCountProduct(HashMap<String, Object> paramMap) {
		adao.getAllCountProduct(paramMap);
	}

	public void productList(HashMap<String, Object> paramMap) {
		adao.productList(paramMap);
	}
}
