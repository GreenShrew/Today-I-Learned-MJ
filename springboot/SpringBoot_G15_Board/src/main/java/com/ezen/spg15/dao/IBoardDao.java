package com.ezen.spg15.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spg15.dto.BoardVO;
import com.ezen.spg15.dto.Paging;
import com.ezen.spg15.dto.ReplyVO;

@Mapper
public interface IBoardDao {

	int getAllCount();

	List<BoardVO> selectBoardAll(Paging paging);

	void insertBoard(BoardVO boardvo);

	void plusReadCount(int num);

	BoardVO getBoard(int num);

	List<ReplyVO> selectReply(int num);

	void addReply(int boardnum, String userid, String content);
}
