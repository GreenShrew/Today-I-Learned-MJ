package com.ezen.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

// 서버에 요청되는 리퀘스트를 다루는 클래스이다.
// 클래스이름 위에 @Controller라는 어노테이션을 표시하면 그 안에 사용되는 @RequestMapping에서 요청 리퀘스트가 검색되고
// 선택되고, 실행된다.
// 첫 페이지의 주소 http://localhost:8090/springmvc/ 는 localhost의 8090 포트중 springmvc 로 대표되는 프로젝트에
// 요청을 보낸 상태이며, 요청의 키워드는 '/' 이다.
// 이는 클래스안에 있는 메소드들 중 @RequestMapping('/') 을 찾아서 실행하고 리턴하라는 뜻이다.
@Controller
public class HomeController {
	
//	@Autowired
//	HomeDao hdao;
	
	@Autowired
	HomeService hs;
	
	// 아래 Logger는 log 출력을 위한 준비이다. 나중에 배울 내용.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// method = RequestMethod.GET 생략 가능하다. 단, POST 방식은 반드시 써야한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		// '/' 를 찾아 실행하고, 아래의 내용을 출력을 위해 가져간다.
		
		Date date = new Date();	// 오늘 날짜
		// 현재 재역에 맞는 날짜 형식 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// 생성한 형식에 오늘 날짜 적용
		String formattedDate = dateFormat.format(date);
		// request.setAttribute를 대신할 정보 전달 객체 : model, addAttribute로 저장만 하면 목적지에 자동 전달된다.
		// 메소드의 전달인수로 선언하고 사용한다.
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// String 형 리턴
		// 리턴된 String은 servlet-context.xml에 정의된 경로와 파일 확장자가 조립되어져서
		// "/WEB-INF/views/" + "home" + ".jsp" 이 파일을 찾아서 웹브라우저에 표시되도록 응답한다.
	}
	
	
	@RequestMapping("/main")	// 하나만 쓰면 value로 인식한다.
	public String main() {
		return "main";
	}
	
	
	@RequestMapping("/other")
	public String other(Model model) {
//		HomeDao hdao = new HomeDao();		// dao 객체 생성
		
//		String message = hdao.getMessage();	// dao 의 getMessage 메소드 실행
	
		String message = hs.getMessage();	// service 의 getMessage 메소드 실행
		model.addAttribute("message", message);	// 리턴받은 값을 model에 저장
		
		return "other";
	}
}
