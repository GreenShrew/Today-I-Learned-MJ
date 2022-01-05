package com.ezen.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/updateForm.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {	// 로그인된 사람이 없다면
			url = "member/loginForm.jsp";
		}
		
		/*		이 부분이 굳이 필요하지 않은 이유
		 * 이미 로그인이 되어있다!
		// 수정할 회원의 정보를 조회해서 dto로 리턴받고, 이를 request에 저장하여 이동한다.
		// 이 자료는 수정할 입력란에 최초 위치할 데이터로 사용된다.
		String userid = request.getParameter("userid");	// main.jsp에서 온 정보가 여기 저장
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		request.setAttribute("updateMember", mdto);
		// 같은 정보를 session에서 loginUser 라는 이름으로 저장하고 있으므로,
		// 현재 코드는 주석처리해도 무방하다.
		*/
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 데이터를 하나하나 mdto에 저장
		MemberDto mdto = new MemberDto();
		mdto.setName(request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.updateMember(mdto);
		
		if(result==1) {
			request.setAttribute("message", "회원 정보를 수정하였습니다.");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);	// 세션 로그인 정보를 바뀐 정보로 교체
		}else {
			request.setAttribute("message", "회원 정보 수정에 실패하였습니다.");
		}
		RequestDispatcher dp = request.getRequestDispatcher("main.do");
		dp.forward(request, response);
	}

}
