package com.ezen.spg15.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spg15.dao.IMemberDao;
import com.ezen.spg15.dto.MemberVO;

@Service
public class MemberService {

	@Autowired
	IMemberDao mdao;

	public MemberVO getMember(String userid) {
		return mdao.getMember(userid);
	}

	public void insertMember(MemberVO membervo) {
		mdao.insertMember(membervo);
	}

	public void updateMember(MemberVO membervo) {
		mdao.updateMember(membervo);
	}
}
