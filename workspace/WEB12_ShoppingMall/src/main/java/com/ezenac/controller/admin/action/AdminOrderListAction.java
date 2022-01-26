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
import com.ezenac.dto.OrderVO;
import com.ezenac.util.Paging;

public class AdminOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/order/orderList.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo==null) {
			url = "shop.do?command=admin";
		}else {
			// 현재 화면에 표시될 페이지 설정
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page") != null){
				page = (int) session.getAttribute("page");
			}else {
				page = 1;
				session.removeAttribute("page");
			}
			
			// 목록을 돌아가면 검색어 사라지는 문제 해결
			String key = "";
			if(request.getParameter("key") != null) {		// 검색어가 없을경우
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else if(session.getAttribute("key") != null) {
				key = (String) session.getAttribute("key");
			}else {
				session.removeAttribute("key");
				key="";
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminDao adao = AdminDao.getInstance();
			int count = adao.getAllCount("order_view", "oseq", key);
			
			paging.setTotalCount(count);
			request.setAttribute("paging", paging);
			
			ArrayList<OrderVO> orderList = adao.listOrder(paging, key);
			request.setAttribute("orderList", orderList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
