package com.ezen.spg16.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBoardDao {

	void selectBoard(HashMap<String, Object> paramMap);

	void getAllCount(HashMap<String, Object> paramMap);

}
