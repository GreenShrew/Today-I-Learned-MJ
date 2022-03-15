package com.ezen.spg14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

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

	@Autowired
	TransactionTemplate tt;
	
	
}
