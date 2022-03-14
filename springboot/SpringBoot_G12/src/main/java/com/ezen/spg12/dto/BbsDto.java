package com.ezen.spg12.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BbsDto {

	private int id;
	
	@NotNull(message="Writer is Null")
	@NotEmpty(message="Writer is Empty")
	private String writer;
	
	@NotNull(message="Title is Null")
	@NotEmpty(message="Title is Empty")
	private String title;
	
	@NotNull(message="Content is Null")
	@NotEmpty(message="Content is Empty")
	private String content;
}
