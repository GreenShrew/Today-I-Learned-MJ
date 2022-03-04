package com.ezen.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.Paging;
import com.ezen.board.dto.ReplyVO;

@Service
public class BoardService {

	@Autowired
	BoardDao bdao;

//	public ArrayList<BoardDto> getBoardsMain() {	리턴값이 달라졌으므로 과거에 쓰던 이 메소드는 주석처리하고 아래 getBoardsMain을 쓴다.
//		ArrayList<BoardDto> list = bdao.getBoardsMain();
//		return list;
//	}
	
	public HashMap<String, Object> getBoardsMain(int page){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		// 1. 페이징 처리
		Paging paging = new Paging();
		paging.setPage(page);
		int count = bdao.getAllCount();		// 총게시물 갯수 count
		paging.setTotalCount(count);		// paging 객체의 각 변수 값 계산
		resultMap.put("paging", paging);
		
		
		// 2. paging 객체에 의한 게시물 조회
		ArrayList<BoardDto> list = bdao.getBoardsMain(paging);
		
		
		// 3. 댓글 갯수 조회
		for(BoardDto bdto : list) {
			int cnt = bdao.replyCount(bdto.getNum());	// 게시물 번호로 댓글 갯수 count
			bdto.setReplycnt(cnt);
		}
		
		resultMap.put("boardList", list);
		
		
		
		return resultMap;
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
		
		// 게시글 조회
		BoardDto bdto = bdao.getBoard(num);
		paramMap.put("bdto", bdto);
		
		// 댓글 조회
		ArrayList<ReplyVO> list = bdao.getReply( num );
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

	public void deleteReply(int replynum) {
		bdao.deleteReply(replynum);
	}

	public BoardDto getBoardOne(int num) {
		BoardDto bdto = bdao.getBoard(num);
		return bdto;
	}

	public void boardUpdate(BoardDto bdto) {
		bdao.boardUpdate(bdto);
	}

	public void boardDelete(int num) {
		bdao.boardDelete(num);
	}
}
