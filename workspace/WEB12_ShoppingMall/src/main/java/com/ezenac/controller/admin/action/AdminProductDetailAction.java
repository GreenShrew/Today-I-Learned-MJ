package com.ezenac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.ProductDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.ProductVO;

public class AdminProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목적지
		String url = "admin/product/productDetail.jsp";
		// 로그인검사
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) {
			url = "shop.do?command=admin";
		}else {
			String pseq = request.getParameter("pseq");
			// 이미 만들어져있는 메소드 사용
			ProductDao pdao = ProductDao.getInstance();
			ProductVO pvo = pdao.getProduct(Integer.parseInt(pseq));
			
			// 카테고리별 타이틀을 배열에 저장
			// 배열의 첫 부분은 0이므로 Heels를 1로 만들려고 0을 추가했다.
			String [] kindList = {"0", "Heels", "Boots", "Sandals", "Snicakers", "Slipers" , "Sale"};
			// 검색해온 상품에서 kind 값 추출 & 상품의 kind 값을 정수로 변환
			int index = Integer.parseInt(pvo.getKind());
			
			// 추출한 kind 번호로 배열에서 해당 타이틀 추출 & 리퀘스트에 저장
			request.setAttribute("kind", kindList[index]);
			request.setAttribute("productVO", pvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
