package com.mboard.controller;

import com.mboard.controller.action.Action;
import com.mboard.controller.action.MainAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("main")) {
			ac = new MainAction();
		}
		
		return ac;
	}
	
}
