package com.ezen.spg09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	UserDao udao;
	
	@RequestMapping("/")
	public String userListPage(Model model) {
		List<UserDto> list = udao.list();
		
		model.addAttribute("users", list);
		return "userlist";
	}
}
