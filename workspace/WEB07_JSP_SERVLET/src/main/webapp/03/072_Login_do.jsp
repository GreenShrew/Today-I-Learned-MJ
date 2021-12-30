<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//	072_Login_do.jsp

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

if(id.equals("hong") && pwd.equals("1234")){
	session.setAttribute("loginUser",id);		// 로그인 사용자 id를 세션에 저장
	response.sendRedirect("073_main.jsp");
}else{
	response.sendRedirect("071_LoginForm.jsp");
}
%>