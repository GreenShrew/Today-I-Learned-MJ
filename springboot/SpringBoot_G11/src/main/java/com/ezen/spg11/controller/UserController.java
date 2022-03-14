package com.ezen.spg11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.spg11.dao.IUserDao;
import com.ezen.spg11.dto.UserDto;

@Controller
public class UserController {

	@Autowired
	IUserDao udao;
	
	@RequestMapping("/")
	public String root(Model model) {
		List<UserDto> list = udao.list();
		// 인터페이스에 추상메소드를 호출하면, 인터페이스가 해당 메소드를 xml에서 실행해주는 형식
		// xml 파일에는 메소드가 아닌 실행 가능한 무언가가 있다.
		model.addAttribute("users", list);
		return "userlist";
	}
}
