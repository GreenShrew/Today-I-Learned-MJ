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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")		// 여기를 변경하면 이 클래스를 명명할 수 있는 '닉네임'을 바꾸게 된다.
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/loginForm.jsp";
		
		// 서블릿에서 세션은 아래와 같이 request에서 getSession()으로 전달받아야(생성해야) 사용 가능하다.
		HttpSession session = request.getSession();
		// .jsp 파일에는 이미 request와 response와 session, application 등이 이미 존재하기 떄문에 session을 바로 사용하는것이 가능하다.
		// 하지만 서블릿은 그렇지 않고, request와 response를 전달받아 사용하기 때문에 전달된 request를 통해 session을 꺼내서 사용한다.
		
		if(session.getAttribute("loginUser") != null) {
			// loginUser 세션값이 null이 아니라면
			url = "main.do";		// 누군가 로그인 되어있는 상태라면 Forwarding 될 경로를 'main.jsp'로 변경한다.
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);		// 위 주소로 Forwarding
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 아이디와 비밀번호를 변수에 저장
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		// 전달된 id로 member 테이블에서 회원을 검색하고, 검색 결과에 따라 pwd와 비교한다.
		// 그리고 그 결과에 따라 정상 로그인 여부를 결정한다.
		
		// 로그인이 실패했을때를 대비해서 Forwarding 할 경로를 먼저 설정한다.
		String url = "member/loginForm.jsp";
		// 정상 로그인시에 url값이 main.jsp로 변경된다.
		
		// Dao의 메소드를 호출하기 위해 객체를 생성한다.
		MemberDao mdao = MemberDao.getInstance();
		// id로 검색해서 해당 아이디의 멤버 정보를 dto 형태로 리턴받는다.
		MemberDto mdto = mdao.getMember(id);
		
		if(mdto == null) {
			request.setAttribute("message", "아이디가 없어요.");
		} else if(mdto.getPwd() == null) {	// 비밀번호를 안 적은 경우
			request.setAttribute("message", "비밀번호 오류.");
		} else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 틀립니다.");
		} else if(mdto.getPwd().equals(pwd)) {
			url = "main.do";		// 로그인 성공시 url을 바꾼다.
			HttpSession session = request.getSession();		// doGet 메소드쪽에 이런식으로 session을 만드는 이유가 있다.
			session.setAttribute("loginUser", mdto);		// 세션에 검색된 사용자를 저장한다.
		} else {	// 어쨌든 로그인 실패
			request.setAttribute("message", "무슨 이유에서인지 로그인이 안 됩니다.");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);		// 저장된 url로 forwarding 한다.
	}

}
