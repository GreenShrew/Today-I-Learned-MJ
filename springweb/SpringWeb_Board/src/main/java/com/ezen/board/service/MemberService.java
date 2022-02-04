package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

@Service	// 이러한 annotation을 붙이면 내가 보지 못하는 어딘가에서 저절로 Spring 컨테이너에 MemberService bean이 추가된다!
public class MemberService {
	
	@Autowired
	MemberDao mdao;

	public MemberDto getMember(String id) {
		MemberDto mdto = mdao.getMember(id);	// mdao에서 진짜로 정보를 가져온다
		return mdto;
	}
}
