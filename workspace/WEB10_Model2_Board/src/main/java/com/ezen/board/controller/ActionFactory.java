package com.ezen.board.controller;

import com.ezen.board.controller.action.Action;
import com.ezen.board.controller.action.IndexAction;
import com.ezen.board.controller.action.LoginAction;
import com.ezen.board.controller.action.MainAction;

public class ActionFactory {

	// 싱글톤 패턴으로 변경
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	// getAction 생성
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) {
			ac = new IndexAction();
		}else if(command.equals("login")) {
			ac = new LoginAction();
		}else if(command.equals("main")) {
			ac = new MainAction();
		}
		return ac;
	}
	
}
