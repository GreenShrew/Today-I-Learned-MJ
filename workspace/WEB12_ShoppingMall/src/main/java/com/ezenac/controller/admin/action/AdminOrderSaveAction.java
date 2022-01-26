package com.ezenac.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;

public class AdminOrderSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=adminOrderList";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		
		if(avo==null) {
			url = "shop.do?command=admin";
		}else {
			String [] odseqs = request.getParameterValues("result");
			AdminDao adao = AdminDao.getInstance();
			for(String odseq : odseqs) {
				adao.updateOrderResult(Integer.parseInt(odseq));
			}
		}
		response.sendRedirect(url);
	}

}
