package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// login.jsp에서 id와 pwd의 파라미터를 받아 id로 DB를 조회해 아이디가 있는지, 테이블의 pwd와 입력 pwd가 같은지 검사한다.
		String url = "member/login.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo == null) {
			request.setAttribute("message", "아이디가 없어요");
		} else if(mvo.getPwd() == null) {
			request.setAttribute("message", "회원정보 오류. 관리자에게 문의하세요.");
		} else if(!mvo.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 틀려요.");
		} else if(mvo.getPwd().equals(pwd)) {		// 로그인 성공시 session에 해당 회원의 정보를 저장하여 창이 닫힐때까지 보관한다.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			url = "shop.do?command=index";
		} else {
			request.setAttribute("message", "로그인이 실패했습니다. 관리자에게 문의하세요.");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
