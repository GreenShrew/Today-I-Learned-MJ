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
			
			String sub = request.getParameter("sub");
			if(sub != null && sub.equals("y")) {		// sub_menu의 버튼을 누르면 sub에 y값이 들어있으므로, null이 아니게 되어 if문이 실행된다!
				session.removeAttribute("key");
				session.removeAttribute("page");
			}
			
			int page = 1;	// 처음 접속시 page는 1페이지라고 설정
			if(request.getParameter("page") != null) {	// 만약 이전 페이지에서 넘어온 page값이 null이 아니라면, 즉 첫 방문이 아니라면
				page = Integer.parseInt(request.getParameter("page"));	// 넘어온 page 값을 page로 설정한다.
				session.setAttribute("page", page);			// 세션에 page를 저장한다.
				// 위에건 특정 페이지를 보는 경우에 실행
				// 아래는 페이지에 대한 정보를 잃어버릴 것 같은 경우에 실행
			}else if(session.getAttribute("page") != null) {		// 세션에 page가 저장되어 있다면 현재 페이지로 session을 저장.
				page = (int) session.getAttribute("page");		// 위의 if문이 걸러진 내용...즉, 페이지 이동이 아니라 게시물을 눌렀을 경우.
			}else {		// 
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);	// 페이지를 현재 페이지로 셋팅
			
			AdminDao adao = AdminDao.getInstance();

			
			String key = "";
			if(request.getParameter("key") != null) {		// 검색어가 있을 경우
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else if(session.getAttribute("key") != null) {
				key = (String) session.getAttribute("key");
			}else {
				session.removeAttribute("key");
				key="";
			}
			
			// 검색어는 레코드 갯수를 세는 동작부터 영향을 미친다.
			int count = adao.getAllCount("product", "name", key);		// 검색어를 적용할 시작 위치!
			// 주의! key는 변수라서 따옴표를 붙이지 않는다. product와 name은 필드명이기 때문에 따옴표를 사용한다.
			
			paging.setTotalCount(count);	// 검색한 내용의 총 갯수를 보내 paging의 모든 변수를 계산하도록 한다.
			request.setAttribute("paging", paging);	// paging.jsp에서 쓰게된다.
			
			ArrayList<ProductVO> productList = adao.listProduct(paging, key);
			request.setAttribute("productList", productList);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
