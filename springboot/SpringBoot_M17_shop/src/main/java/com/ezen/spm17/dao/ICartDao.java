package com.ezen.spm17.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICartDao {

	void insertCart(HashMap<String, Object> paramMap);

}
