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
import com.ezenac.dto.MemberVO;
import com.ezenac.util.Paging;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/memberList.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
			String sub = request.getParameter("sub");
			if(sub!=null && sub.equals("y")) {
				session.removeAttribute("key");
				session.removeAttribute("page");
			}
			
			int page = 1;
			if(request.getParameter("page")!=null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page")!=null) {
				page = (int)session.getAttribute("page");
			}else {
				session.removeAttribute("page");
			}
			
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
			int count = adao.getAllCount("member", "name", key);
			paging.setTotalCount(count);
			request.setAttribute("paging", paging);
			
			ArrayList<MemberVO> memberList = adao.listMember(paging, key);
			request.setAttribute("memberList", memberList);
			session.setAttribute("key3", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
