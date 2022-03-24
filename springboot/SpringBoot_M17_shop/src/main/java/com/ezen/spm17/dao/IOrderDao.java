package com.ezen.spm17.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderDao {

	void insertOrder(HashMap<String, Object> paramMap);

	void listOrderByOseq(HashMap<String, Object> paramMap);

}
