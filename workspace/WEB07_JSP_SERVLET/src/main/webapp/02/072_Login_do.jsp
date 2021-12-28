<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<!-- JSP 문법에 의한 로그인 체크 동작만 필요한 페이지이므로, 별도의 HTML 태그는 사용하지 않는다. -->
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

// 원하는 아이디와 비밀번호가 전달되어왔는지 확인 후, 맞으면 073_loginOk.jsp로 이동한다.
// jsp 문법으로 페이지 이동은 response.sendRedirect();
if(id.equals("hong") && pwd.equals("1234"))
	response.sendRedirect("073_loginOK.jsp?name=" + URLEncoder.encode("홍길동", "UTF-8"));
else
	response.sendRedirect("071_loginForm.jsp");

// jsp 파일에서 로그인 절차를 진행하면 안 좋은점 #1
// 한글 전달값에 대한 인코딩이 UTR-8이 아니어서 한글이 깨진다.
// 별도의 URLEncoding 객체를 사용해야한다.

%>