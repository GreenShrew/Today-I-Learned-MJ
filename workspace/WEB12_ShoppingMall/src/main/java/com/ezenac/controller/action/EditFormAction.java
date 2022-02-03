package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dto.MemberVO;

public class EditFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");		// 현재 로그인한 유저의 모든 정보를 가져왔다.
		
		String addr = mvo.getAddress();
		
		// 구 주소형식 : 서울시 마포구 대현동 (여기서끊어짐) 번지 및 나머지 주소
		// 보통 구 주소형식에서 세번째 빈칸 위치가 주소가 앞뒤로 끊어지는 위치이다.
		int k1 = addr.indexOf(" ");	// 첫번째 공백의 위치를 찾는 메소드
		int k2 = addr.indexOf(" ", k1+1);	// 첫번째 공백 위치의 다음 위치부터 두번째 공백 위치를 찾음
		int k3 = addr.indexOf(" ", k2+1);	// 두번째 공백 위치의 다음 위치부터 세번째 공백을 찾음
		
		// 서울시 마포구 대현동 115-15 : 세번째 공백 위치 k3값은 11이다. (0부터 시작)
		// 맨 앞부터 세번쨰 공백 위치 바로 전까지가 주소의 앞부분이 된다.
		String addr1 = addr.substring(0, k3);
		
		// 세번째 공백 뒷글자부터 맨 끝까지가 주소의 뒷부분이 된다.
		String addr2 = addr.substring(k3+1);	// 문자열 자르기 substring

		request.setAttribute("addr1", addr1);
		request.setAttribute("addr2", addr2);
		
		RequestDispatcher dp = request.getRequestDispatcher("member/updateForm.jsp");
		dp.forward(request, response);
	}

}
