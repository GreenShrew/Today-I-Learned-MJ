package com.ezen.board.controller;

import com.ezen.board.controller.action.Action;
import com.ezen.board.controller.action.BoardCheckPassAction;
import com.ezen.board.controller.action.BoardDeleteAction;
import com.ezen.board.controller.action.BoardPassFormAction;
import com.ezen.board.controller.action.BoardUpdateAction;
import com.ezen.board.controller.action.BoardUpdateFormAction;
import com.ezen.board.controller.action.BoardViewAction;
import com.ezen.board.controller.action.BoardWriteAction;
import com.ezen.board.controller.action.BoardWriteFormAction;
import com.ezen.board.controller.action.EditMemberAction;
import com.ezen.board.controller.action.EditMemberFormAction;
import com.ezen.board.controller.action.IdCheckAction;
import com.ezen.board.controller.action.IndexAction;
import com.ezen.board.controller.action.JoinAction;
import com.ezen.board.controller.action.JoinFormAction;
import com.ezen.board.controller.action.LoginAction;
import com.ezen.board.controller.action.LogoutAction;
import com.ezen.board.controller.action.MainAction;
import com.ezen.board.controller.action.boardViewWithoutCountAction;

public class ActionFactory {
	
	// 싱글톤 패터으로 변경
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	// getAction 생성
	public Action getAction(String command) {
		
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("login")) ac = new LoginAction();	
		else if(command.equals("main")) ac = new MainAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idcheck")) ac = new IdCheckAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("editMemberForm")) ac = new EditMemberFormAction();
		else if(command.equals("editMember")) ac = new EditMemberAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("boardView")) ac = new BoardViewAction();
		else if(command.equals("boardWriteForm")) ac = new BoardWriteFormAction();
		else if(command.equals("boardWrite")) ac = new BoardWriteAction();
		else if(command.equals("boardPassForm")) ac = new BoardPassFormAction();
		else if(command.equals("boardCheckPass")) ac = new BoardCheckPassAction();
		else if(command.equals("boardUpdateForm")) ac = new BoardUpdateFormAction();
		else if(command.equals("boardUpdate")) ac = new BoardUpdateAction();
		else if(command.equals("boardViewWithoutCount")) ac = new boardViewWithoutCountAction();
		else if(command.equals("boardDelete")) ac = new BoardDeleteAction();
		
		
		
		return ac;
		
	}
	
	
	
}
