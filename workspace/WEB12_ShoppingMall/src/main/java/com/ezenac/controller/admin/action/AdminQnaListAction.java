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
import com.ezenac.dto.QnaVO;
import com.ezenac.util.Paging;

public class AdminQnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaList.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) {
			url = "shop.do?command=admin";
		}else {
			String sub = request.getParameter("sub");
			if(sub!=null) {
				session.removeAttribute("key");
				session.removeAttribute("page");
			}
			
			int page = 1;
			if(request.getParameter("page")!=null) {
				page = Integer.parseInt(request.getParameter("page"));
			}else if(session.getAttribute("page")!=null) {
				page = (int)session.getAttribute("page");
			}else {
				page=1;
				request.removeAttribute("page");
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
			int count = adao.getAllCountForQna(key);	// Content의 내용으로도 검색이 가능하도록 제작.
			// int count = adao.getAllCount("Qna", "subject", "content", key);		// 위처럼 새 메소드를 만들지 않고 오버로딩 하는 방법도 있다..
			paging.setTotalCount(count);
			
			ArrayList<QnaVO> qnaList = adao.listQna(paging, key);
			request.setAttribute("paging", paging);
			request.setAttribute("qnaList", qnaList);
			session.setAttribute("key", key);
			
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
