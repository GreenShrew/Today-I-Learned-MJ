package com.ezen.spg15.dao;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spg15.dto.MemberVO;

@Mapper
public interface IMemberDao {

	public MemberVO getMember(String userid);

	public void insertMember(MemberVO membervo);

	public void updateMember(MemberVO membervo);

}
