package com.ezen.spm17.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.spm17.dao.IMemberDao;

@Service
public class MemberService {

	@Autowired
	IMemberDao mdao;

	public void getMember(HashMap<String, Object> paramMap) {
		mdao.getMember(paramMap);
	}

	public void selectAddressByDong(HashMap<String, Object> paramMap) {
		mdao.getAddress(paramMap);
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertMember(HashMap<String, Object> paramMap) {
		mdao.insertMember(paramMap);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateMember(HashMap<String, Object> paramMap) {
		mdao.updateMember(paramMap);
	}
}
