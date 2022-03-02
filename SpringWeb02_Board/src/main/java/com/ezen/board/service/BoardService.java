package com.ezen.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

@Service
public class BoardService {

	@Autowired
	BoardDao bdao;

	public ArrayList<BoardDto> getBoardsMain() {
		ArrayList<BoardDto> list = bdao.getBoardsMain();
		return list;
	}
}
