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

	void insertReply(ReplyVO rvo);

	void deleteReply(int num);

	void updateBoard(BoardVO boardvo);

	void deleteBoard(int num);

	void deleteReplyAll(int num);

	int getCount(int num);

}
