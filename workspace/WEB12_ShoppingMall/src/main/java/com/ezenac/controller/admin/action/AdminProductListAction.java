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
import com.ezenac.dto.ProductVO;
import com.ezenac.util.Paging;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo==null) {
			url = "shop.do?command=admin";
		}else {
			
			int page = 1;	// 처음 접속시 page는 1페이지라고 설정
			if(request.getParameter("page") != null) {	// 만약 이전 페이지에서 넘어온 page값이 null이 아니라면, 즉 첫 방문이 아니라면
				page = Integer.parseInt(request.getParameter("page"));	// 넘어온 page 값을 page로 설정한다.
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminDao adao = AdminDao.getInstance();
			
			int count = adao.getAllCount();
			paging.setTotalCount(count);
			request.setAttribute("paging", paging);
			
			ArrayList<ProductVO> productList = adao.listProduct(paging);
			request.setAttribute("productList", productList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
