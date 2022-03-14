package com.ezen.spg10.dao;

import java.util.List;

import com.ezen.spg10.BbsDto;

public interface IBbsDao {

	public List<BbsDto> list();	// 게시물 전체조회 - 매개변수 없고, 리턴값은 List<BbsDto>
	public int write(BbsDto bdto);		// 게시물 쓰기 - 매개변수 BbsDto형, 리턴 int
	public int update(BbsDto bdto);	// 게시물 수정 - 매개변수 BbsDto형, 리턴 int
	public int delete(int id);		// 게시물 삭제 - 매개변수 int, 리턴 int
	public BbsDto view(int id);		// 게시물 하나 보기 - 매개변수 int, 리턴 BbsDto
}
