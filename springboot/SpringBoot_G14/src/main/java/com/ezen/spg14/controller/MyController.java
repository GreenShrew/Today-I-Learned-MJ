package com.ezen.spg14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg14.service.MyService;

@Controller
public class MyController {

	@Autowired
	MyService ms;
	
	
	@RequestMapping("/")
	public String root() {
		return "buy_ticket";
	}
	
	
	@RequestMapping("buyTicketCard")
	public String buy_Ticket_Card(
			@RequestParam("id") String id,
			@RequestParam("amount") int amount,
			@RequestParam("error") int error, Model model) {
		// 현재 해야할 일은 전달된 아이디가 티켓을 전달된 구매갯수만큼 구매한걸로 데이터베이스 테이블에 insert 하는것.
		int result = 0;
		// int result = ms.buy(id, amount, error);	// result는 DB에 전달이 잘 됐나 안 됐나 판단하려는 것.

		model.addAttribute("id", id);
		model.addAttribute("amount", amount);
		
		if(result==1) {
			return "buy_ticket_end";
		}else {
			return "buy_ticket_error";
		}
	}
}
