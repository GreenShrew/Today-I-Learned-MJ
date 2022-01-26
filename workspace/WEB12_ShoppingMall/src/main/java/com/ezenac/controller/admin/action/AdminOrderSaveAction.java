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
		String url = "admin/order/orderList.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		String [] odseqarr = request.getParameterValues("odseq");
		if(avo==null) {
			url = "shop.do?command=admin";
		}else {
			AdminDao adao = AdminDao.getInstance();
			for(String odseq : odseqarr) {
				adao.orderResult(Integer.parseInt(odseq));
			}
		}
		response.sendRedirect(url);
	}

}
