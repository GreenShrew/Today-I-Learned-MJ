package com.ezenac.controller;

import com.ezenac.controller.action.Action;
import com.ezenac.controller.action.IndexAction;
import com.ezenac.controller.action.LoginFormAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		
		return ac;
	}
}
