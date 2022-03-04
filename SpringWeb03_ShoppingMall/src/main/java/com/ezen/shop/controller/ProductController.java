package com.ezen.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.shop.dto.ProductVO;
import com.ezen.shop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServlet request, Model model) {

		List<ProductVO> nlist = ps.getNewList();
		List<ProductVO> blist = ps.getBestList();
		// List는 ArrayList의 부모객체이다.
		// 이 프로젝트에서 사용하려고 하는 템플릿(데이터베이스 객체)가 List만 지원하고 있어서 List를 사용한다.
		model.addAttribute("newProductList", nlist);
		model.addAttribute("bestProductList", blist);
		
		return "index";
	}
}
