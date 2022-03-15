package com.ezen.spg15.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spg15.dto.BoardVO;
import com.ezen.spg15.dto.Paging;

@Mapper
public interface IBoardDao {

	int getAllCount();

	List<BoardVO> selectBoardAll(Paging paging);

}
