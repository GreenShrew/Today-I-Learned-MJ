package com.ezen.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.MemberDao;
import com.ezen.shop.dto.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDao mdao;

	public MemberVO getMember(String id) {
		return mdao.getMember(id);
	}
}
