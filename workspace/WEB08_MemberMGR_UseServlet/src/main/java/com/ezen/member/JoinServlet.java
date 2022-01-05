package com.ezen.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("member/joinForm.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDto mdto = new MemberDto();	// 전달된 회원가입 양식에서의 데이터를 mdto에 차곡차곡 넣을 준비
		MemberDao mdao = MemberDao.getInstance();
		
		// 이런 방법을 mdto에 넣는다.
		String name = request.getParameter("name");
		mdto.setName(name);
		// 하지만 굳이 변수를 만들 이유가 없으므로 데이터를 받자마자 집어넣도록 한다. (어차피 String 데이터라 무방하다.)
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		// 얘는 value가 0, 1 인데 value="0" 으로 작성되어있다. 즉 String 값이므로 int형으로 캐스팅 해야한다.
		
		int result = mdao.insertMember(mdto);
		if(result == 1) request.setAttribute("message", "회원가입 완료!");
		else request.setAttribute("message", "회원가입 실패!");
		
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);	// 완료되었다면 로그인 창으로 되돌려보낸다.
		}

}
