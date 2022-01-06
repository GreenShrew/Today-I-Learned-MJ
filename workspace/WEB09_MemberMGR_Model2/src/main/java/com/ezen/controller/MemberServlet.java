package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.action.Action;
import com.ezen.controller.action.JoinFormAction;
import com.ezen.controller.action.LoginAction;
import com.ezen.controller.action.LoginFormAction;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 같이 전달된 command 파라미터를 getParameter 메소드로 받는다.
		String command = request.getParameter("command");
		// command에 전달된 값에 따라 어떤 작업을 할지가 결정이 되어 실행된다.
		
		// 각 command별 실행할 작업들은 해당 실행코드가 들어있는 클래스 내부에 존재한다.
		// 그 중에서도 execute 메소드 안에 있다.
		// Model2 방식은 각 기능별로 클래스가 제작되어 실행되기를 기다리고, command 값에 따라 선택되어 실행되는 형식이다!
		
		Action ac = null;		// import 할 때 내가 만든 클래스를 import!

		/*
		if(command.equals("loginForm")) {
//			LoginFormAction lfa = new LoginFormAction();	// 만들어놓은 자바클래스의 객체를 만들고
//			lfa.execute(request, response);	// jsp에서 받은 매개변수 request와 response를 전달인수로 java 클래스에서 만들어둔 execute 메소드로 보낸다.
			ac = new LoginFormAction();
		} else if(command.equals("login")) {
			// 로그인 동작이 들어있는 클래스의 new 인스턴스를 만들고, execute 메소드를 호출!
//			LoginAction la = new LoginAction();
//			la.execute(request, response);
			ac = new LoginAction();
		} else if(command.equals("joinForm")) {
			// 회원가입 Form으로 이동시켜주는 동작이 들어있는 클래스의 new 인스턴스를 만들고, execute 메소드를 호출!
//			JoinFormAction jfa = new JoinFormAction();
//			jfa.execute(request, response);
			ac = new JoinFormAction();
		}
		
		----> Action이라는 interface를 각 클래스에 상속시키면 매번 LoginFormAction lfa = new LoginFormAction(); 과 같이 객체를 만들 필요가 없다.
		----> 또한, ac.execute(request, response);로 묶어서 command에 알맞은 execute 메소드를 실행할 수 있다!
	*/
		
		// 각 기능을 탑재하고 있는 new 인스턴스의 생성과 execute()의 실행은
		// 클래스들이 상속(implements)받은 부모 인터페이스(Action)의 레퍼런스 변수에 저장하고,
		// 레퍼런스 변수명.execute로 실행한다. (여기서는 ac)
		
		// 각 클래스에 있는 execute 메소드는 Action 인터페이스에 존재하는 추상 메소드이다.
		// 각 클래스가 Action 인터페이스를 상속(implements)하여, execute 메소드가 오버라이딩되면
		// Action 인터페이스의 레퍼런스 변수로 자식 클래스의 execute 메소드를 호출하여 사용한다.
		
		ActionFactory af = ActionFactory.getInstance();
		ac = af.getAction(command);
		// command를 전달하면 메소드에서 위의 조립동작을 한 후 결과 객체를 리턴해준다.
		
		if(ac==null) {
			System.out.println("ac가 null입니다. command를 확인해주세요. command : " + command);
		} else {
			ac.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
