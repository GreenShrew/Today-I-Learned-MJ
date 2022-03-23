package com.ezen.spg16.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spg16.dao.IBoardDao;

@Service
public class BoardService {

	@Autowired
	IBoardDao bdao;

	public void selectBoard(HashMap<String, Object> paramMap) {
		bdao.selectBoard( paramMap );		
	}
	public void getAllCount(HashMap<String, Object> paramMap) {
		bdao.getAllCount( paramMap );		
	}
	public void boardView(HashMap<String, Object> paramMap) {
		bdao.plusReadCount( paramMap );
		bdao.boardView( paramMap );
	}
	public void insertReply(HashMap<String, Object> paramMap) {
		bdao.insertReply( paramMap );		
	}
	public void boardViewWithoutCount(HashMap<String, Object> paramMap) {
		bdao.boardView( paramMap );	// 	plusReadCount 없이 boardView  만 실행
	}
	public void deleteReply(HashMap<String, Object> paramMap) {
		bdao.deleteReply( paramMap );
	}
	public void getBoard(HashMap<String, Object> paramMap) {
		bdao.getBoard( paramMap );		
	}
	public void updateBoard(HashMap<String, Object> paramMap) {
		bdao.updateBoard( paramMap );
	}
	public void removeBoard(HashMap<String, Object> paramMap) {
		bdao.removeBoard(paramMap);
	}
	public void insertBoard(HashMap<String, Object> paramMap) {
		bdao.insertBoard(paramMap);
	}
}
