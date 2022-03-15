package com.ezen.spg15.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MemberVO {

	@NotEmpty(message="아이디를 입력하세요")
	@NotNull(message="아이디를 입력하세요")
	private String userid;
	@NotEmpty(message="비밀번호를 입력하세요")
	@NotNull(message="비밀번호를 입력하세요")
	private String pwd;
	@NotEmpty(message="이름을 입력하세요")
	@NotNull(message="이름을 입력하세요")
	private String name;
	@NotEmpty(message="이메일을 입력하세요")
	@NotNull(message="이메일을 입력하세요")
	private String email;
	@NotEmpty(message="전화번호를 입력하세요")
	@NotNull(message="전화번호를 입력하세요")
	private String phone;
}
