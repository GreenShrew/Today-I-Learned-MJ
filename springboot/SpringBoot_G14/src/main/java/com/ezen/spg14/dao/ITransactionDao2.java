package com.ezen.spg14.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransactionDao2 {

	void buy(String id, int amount);

}
