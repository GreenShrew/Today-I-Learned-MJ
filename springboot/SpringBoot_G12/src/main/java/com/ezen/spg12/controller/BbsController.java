package com.ezen.spg12.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg12.dao.IBbsDao;
import com.ezen.spg12.dto.BbsDto;

@Controller
public class BbsController {

	@Autowired
	IBbsDao bdao;
	
	@RequestMapping("/")
	public String userlistPage(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
	
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("dto") @Valid BbsDto bbsdto, 
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			if(result.getFieldError("writer")!=null) {
				model.addAttribute("msg", result.getFieldError("writer").getDefaultMessage());
			}else if(result.getFieldError("title")!=null) {
				model.addAttribute("msg", result.getFieldError("title").getDefaultMessage());
			}else if(result.getFieldError("content")!=null) {
				model.addAttribute("msg", result.getFieldError("content").getDefaultMessage());
			}
			return "writeForm";
		}else {	// 정상통과
			bdao.write(bbsdto);
//			bdao.write(bbsdto.getWriter(), bbsdto.getTitle(), bbsdto.getContent());
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/view")
	public String view(@RequestParam("id") int id, Model model) {
		model.addAttribute("dto", bdao.view(id));
		return "view";
	}
	
}
