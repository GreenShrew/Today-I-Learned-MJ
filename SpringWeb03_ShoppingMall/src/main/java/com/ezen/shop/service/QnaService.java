package com.ezen.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.QnaDao;

@Service
public class QnaService {

	@Autowired
	QnaDao qdao;

	public Object listQna(String userid) {
		return qdao.listQna(userid);
	}
}
