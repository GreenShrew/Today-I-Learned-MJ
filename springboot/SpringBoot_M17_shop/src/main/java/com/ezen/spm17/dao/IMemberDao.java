package com.ezen.spm17.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberDao {

	void getMember(HashMap<String, Object> paramMap);

	void getAddress(HashMap<String, Object> paramMap);

	void insertMember(HashMap<String, Object> paramMap);

	void updateMember(HashMap<String, Object> paramMap);

}
