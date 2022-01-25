package com.ezenac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dto.AdminVO;

public class AdminProductWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 체크부터 하고 해당 페이지로 이동
		String url = "admin/product/productWrite.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginUser");
		
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
			String [] kindList = {"Heels", "Boots", "Sandals", "Shcakers", "Slipers" ,"On Sale"};
			// kind 값 입력시 화면에 표시될 카테고리 이름들을 문자 배열에 넣고 request에 담아서 이동한다.
			request.setAttribute("kindList", kindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
