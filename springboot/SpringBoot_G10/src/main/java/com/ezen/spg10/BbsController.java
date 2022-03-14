package com.ezen.spg10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg10.dao.BbsDao;

@Controller
public class BbsController {

	@Autowired
	BbsDao bdao;
	
	// 첫페이지는 리스트를 조회해서 list.jsp로 이동한다. 
	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("list", bdao.list());
//		System.out.println(bdao.list().size()); 확인용...
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
	
	
	@RequestMapping("view")
	public String view(@RequestParam("id") int id, Model model) {
		model.addAttribute("dto", bdao.view(id));
		return "view";
	}
	
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id") int id) {
		bdao.delete(id);
		return "redirect:/";
	}
}
