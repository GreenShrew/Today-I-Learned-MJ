package com.ezen.controller;

import com.ezen.controller.action.Action;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("productView")) ac = new ProductViewAction();
		
		
		return ac;
	}
	
	
	
}
