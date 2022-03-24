package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping("/")
	public ModelAndView main(HttpServletRequest request, Model model) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ref_cursor1", null);	// 신상품을 담을 cursor1
		paramMap.put("ref_cursor2", null);	// 베스트 상품을 담을 cursor2
		
		ps.getBestNewProduct(paramMap);	// 베스트, 신상품을 한번에 담아온다

		// ref_cursor1, ref_cursor2 에 담아온 데이터를 각각 list1, list2 에 넣는다.
		ArrayList<HashMap<String, Object>> list1
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor1");

		ArrayList<HashMap<String, Object>> list2
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		
		mav.addObject("newProductList", list1);
		mav.addObject("bestProductList", list2);
		mav.setViewName("main");
		
		return mav;
	}
	
	
	@RequestMapping(value="/catagory")
	public ModelAndView catagory(Model model, HttpServletRequest request,
			@RequestParam("kind") String kind) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ref_cursor", null);
		paramMap.put("kind", kind);
		
		ps.getKindList(paramMap);
		
		// ref_cursor에 담은 내용을 list 에 저장
		ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		mav.addObject("productKindList", list);
		mav.setViewName("product/productKind");
		
		return mav;
	}
	
	
	@RequestMapping(value="/productDetail")
	public ModelAndView productDetail(Model model, HttpServletRequest request,
			@RequestParam("pseq") int pseq) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ref_cursor", null);
		paramMap.put("pseq", pseq);
		ps.getProduct(paramMap);
		
		ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		// list 에 배열로 저장한 데이터의 첫번째 값을 resultMap에 저장
		HashMap<String, Object> resultMap = list.get(0);
		mav.addObject("productVO", resultMap);
		mav.setViewName("product/productDetail");
		
		return mav;
	}
}
