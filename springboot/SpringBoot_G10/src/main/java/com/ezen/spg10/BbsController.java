package com.ezen.spg10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.spg10.dao.BbsDao;

@Controller
public class BbsController {

	@Autowired
	BbsDao bdao;
	
	// 첫페이지는 리스트를 조회해서 list.jsp로 이동한다. 
	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
	
	
	@RequestMapping("writeForm")
	public String writeForm(Model model) {
		return "writeForm";
	}
	
	
	@RequestMapping("write")
	public String write(BbsDto bbsdto) {
		bdao.write(bbsdto);
		return "redirect:/";
	}
}
