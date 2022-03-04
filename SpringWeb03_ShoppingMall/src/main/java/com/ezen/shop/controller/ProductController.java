package com.ezen.shop.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.shop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServlet request, Model model) {	// 이 매개변수가 일단 쓰이지는 않겠지만, 처음거니깐 그냥 썼다.
		
		return "index";
	}
}
