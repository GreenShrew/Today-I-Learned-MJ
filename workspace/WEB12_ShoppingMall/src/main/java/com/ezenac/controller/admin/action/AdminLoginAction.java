package com.ezenac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 workId, workPwd 를 저장한다.
		String workId = request.getParameter("workId");
		String workPwd = request.getParameter("workPwd");
		
		// 로그인 실패시 로그인창으로
		String url = "shop.do?command=admin";
		
		// AdminDao 생성 후 인스턴스를 얻는다.
		AdminDao adao = AdminDao.getInstance();
		// AdminDao 안의 workerCheck 메소드 생성 후 호출한다.
		AdminVO avo = adao.workerCheck(workId);
		
		if(avo == null) {
			request.setAttribute("msg", "아이디가 없습니다.");
		}else if(avo.getPwd() == null) {
			request.setAttribute("msg", "DB오류. 관리자에게 문의하세요.");
		}else if(!avo.getPwd().equals(workPwd)) {
			request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", avo);
			url = "shop.do?command=adminProductList";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
