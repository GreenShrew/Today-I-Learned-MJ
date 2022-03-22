package com.ezen.spg16.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberDao {

	void getMember(HashMap<String, Object> paramMap);
	void insertMember(HashMap<String, Object> paramMap);
	void updateMember(HashMap<String, Object> mvo);

}
