package com.ezen.controller;

import com.ezen.controller.action.Action;
import com.ezen.controller.action.DeleteMemberAction;
import com.ezen.controller.action.EditAdminAction;
import com.ezen.controller.action.IdCheckAction;
import com.ezen.controller.action.JoinAction;
import com.ezen.controller.action.JoinFormAction;
import com.ezen.controller.action.LoginAction;
import com.ezen.controller.action.LoginFormAction;
import com.ezen.controller.action.LogoutAction;
import com.ezen.controller.action.MainAction;
import com.ezen.controller.action.UpdateAction;
import com.ezen.controller.action.UpdateFormAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	// 넘어온 command에 맞는 ac를 선택하여 조립하고, 이를 다시 넘겨주는 메소드
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("loginForm")) {
			ac = new LoginFormAction();
		} else if(command.equals("login")) {
			ac = new LoginAction();
		} else if(command.equals("joinForm")) {
			ac = new JoinFormAction();
		} else if(command.equals("logout")) {
			ac = new LogoutAction();
		} else if(command.equals("idcheck")) {
			ac = new IdCheckAction();
		} else if(command.equals("join")) {
			ac = new JoinAction();
		} else if(command.equals("updateForm")) {
			ac = new UpdateFormAction();
		} else if(command.equals("update")) {
			ac = new UpdateAction();
		} else if(command.equals("deleteMember")) {
			ac = new DeleteMemberAction();
		} else if(command.equals("main")) {
			ac = new MainAction();
		} else if(command.equals("editAdmin")) {
			ac = new EditAdminAction();
		}
		
		return ac;
	}


}
