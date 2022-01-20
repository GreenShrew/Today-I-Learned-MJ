package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 파라미터들을 mvo에 담는다.
		MemberVO mvo = new MemberVO();
		
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		mvo.setPhone(request.getParameter("phone"));
		
		// 모든 파라미터들이 담긴 객체를 전달인수로 하여 수정 메소드를 호출한다.
		MemberDao mdao = MemberDao.getInstance();
		mdao.updateMember(mvo);
		
		HttpSession session = request.getSession();	// 정보가 수정되었으면 수정된 내용을 세션의 로그인 값으로 변경한다.
		session.setAttribute("loginUser", mvo);
		
		RequestDispatcher dp = request.getRequestDispatcher("shop.do?command=index");
		dp.forward(request, response);
	}

}
