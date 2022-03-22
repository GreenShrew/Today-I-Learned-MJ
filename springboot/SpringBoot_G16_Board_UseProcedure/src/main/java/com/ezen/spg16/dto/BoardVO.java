package com.ezen.spg16.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BoardVO {

	private int num;
	private String userid;
	@NotEmpty(message="비밀번호를 입력하세요(게시글 수정 삭제시 필요합니다)")
	@NotNull(message="비밀번호를 입력하세요(게시글 수정 삭제시 필요합니다)")
	private String pass;
	private String email;
	@NotEmpty(message="제목을 입력하세요")
	@NotNull(message="제목을 입력하세요")
	private String title;
	@NotEmpty(message="내용을 입력하세요")
	@NotNull(message="내용을 입력하세요")
	private String content;
	private int readcount;
	private Timestamp writedate;
	private int replycnt;
	private String imgfilename;
	
}
