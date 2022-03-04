package com.ezen.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyVO;

@Service
public class BoardService {

	@Autowired
	BoardDao bdao;

	public ArrayList<BoardDto> getBoardsMain() {
		ArrayList<BoardDto> list = bdao.getBoardsMain();
		return list;
	}

	public void insertBoard(BoardDto bdto) {
		bdao.insert(bdto);
	}
/*
	public BoardDto boardView(int num) {
		// 게시물 조회
		BoardDto bdto = bdao.getBoard(num);
		
		// 조회수 +1
		bdao.plusReadCount(num);
		return bdto;
	}
	

	public ArrayList<ReplyVO> getReplysOne(int num) {
		ArrayList<ReplyVO> list = bdao.getReply(num);
		
		return list;
	}
	해쉬맵을 쓰기 전에 사용한 방법.
	*/
	public HashMap<String, Object> boardView(int num) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		// 조회수 +1
		bdao.plusReadCount(num);
		
		// 게시물 조회
		BoardDto bdto = bdao.getBoard(num);
		paramMap.put("bdto", bdto);
		
		ArrayList<ReplyVO> list = bdao.getReply(num);
		paramMap.put("replylist", list);
		
		return paramMap;
	}

	public void addReply(ReplyVO rvo) {
		bdao.addReply(rvo);
		
		
	}

	public HashMap<String, Object> boardViewWithoutCount(int num) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
	
		BoardDto bdto = bdao.getBoard(num);
		paramMap.put("bdto", bdto);
		ArrayList<ReplyVO> list = bdao.getReply( num );
		paramMap.put("replylist", list);	
		return paramMap;
	}
}
