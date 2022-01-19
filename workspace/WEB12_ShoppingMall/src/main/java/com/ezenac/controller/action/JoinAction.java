package com.ezenac.controller.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = new MemberVO();

		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress(request.getParameter("addr1")+" "+request.getParameter("addr2"));
		mvo.setPhone(request.getParameter("phone"));
		
		int result = mdao.insertMember(mvo);
		String message = "";
		if(result==1) message="회원가입이 완료되었습니다. 로그인하세요";
		else message = "회원가입에 실패했습니다. 다시 시도해주세요.";
		response.sendRedirect("shop.do?command=loginForm&message=" + URLEncoder.encode(message,"UTF-8"));
	}

}
