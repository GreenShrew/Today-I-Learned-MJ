package com.ezen.controller;

import com.ezen.controller.action.Action;
import com.ezen.controller.action.ProductViewAction;
import com.ezen.controller.action.ProductWriteAction;
import com.ezen.controller.action.ProductWriteFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("productView")) ac = new ProductViewAction();
		else if(command.equals("productWriteForm")) ac = new ProductWriteFormAction();
		else if(command.equals("productWrite")) ac = new ProductWriteAction();
		
		
		return ac;
	}
	
	
	
}
