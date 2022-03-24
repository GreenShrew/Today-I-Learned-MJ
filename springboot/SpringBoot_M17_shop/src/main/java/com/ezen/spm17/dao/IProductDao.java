package com.ezen.spm17.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IProductDao {

	void getBestNewProduct(HashMap<String, Object> paramMap);

	void getKindList(HashMap<String, Object> paramMap);

	void getProduct(HashMap<String, Object> paramMap);

}
