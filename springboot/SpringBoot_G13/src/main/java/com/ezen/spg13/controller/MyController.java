package com.ezen.spg13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg13.service.MyService;

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
		
		int result = ms.buy(id, amount, error);	// result는 DB에 전달이 잘 됐나 안 됐나 판단하려는 것.
		// 전달된 id, 구매갯수, 에러여부를 서비스단에 전달하여 구매작업을 계속 하게 한다.
		// 구매작업 성공여부를 리턴받아서 성공이면 buy_ticket_end.jsp로,
		// 실패이면 buy_ticket_error.jsp로 이동한다.
		
		model.addAttribute("id", id);
		model.addAttribute("amount", amount);
		
		System.out.println(result);
		if(result==1) {
			return "buy_ticket_end";
		}else {
			return "buy_ticket_error";
		}
	}
}
