package com.ezen.spg16.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBoardDao {

	void selectBoard(HashMap<String, Object> paramMap);
	void getAllCount(HashMap<String, Object> paramMap);
	void plusReadCount(HashMap<String, Object> paramMap);
	void boardView(HashMap<String, Object> paramMap);
	void insertReply(HashMap<String, Object> paramMap);
	void deleteReply(HashMap<String, Object> paramMap);
	void getBoard(HashMap<String, Object> paramMap);

}
