package com.ezen.spg14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.spg14.dao.ITransactionDao1;
import com.ezen.spg14.dao.ITransactionDao2;

@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;

	@Autowired
	ITransactionDao2 td2;
	
	@Autowired
	ITransactionDao2 td3;

	@Transactional
	public int buy(String id, int amount, int error) {
		try {
			td1.buy(id, amount);
			int n = 0;
			if(error==1) {
				n = 10/0;	// 강제 에러발생
			}
			td2.buy(id, amount);
			System.out.println("Transaction Commit!");
			return 1;
		}catch(Exception e) {
			System.out.println("Transaction Rollback!");
			return 0;
		}
	}
	
	
}
