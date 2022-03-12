package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

@Service
public class MemberService {

	@Autowired
	MemberDao mdao;
	
	public MemberDto getMember(String id) {
		MemberDto mdto = mdao.getMember(id);
		return mdto;
	}

	public int insertMember(MemberDto mdto) {
		int result = mdao.insertMember(mdto);
		return result;
	}

	public int updateMember(MemberDto mdto) {
		int result = mdao.updateMember(mdto);
		return result;
	}

}
