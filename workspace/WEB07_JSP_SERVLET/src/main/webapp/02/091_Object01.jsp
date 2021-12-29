<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("name","page man");	// pageContext : 현재 페이지까지
request.setAttribute("name", "request man");	// request : 다음 페이지까지
session.setAttribute("name","session man");	// session : 브라우저가 닫힐떄까지
application.setAttribute("name","application man");		// application : 서버가 꺼지거나 리스타트 될 때까지

System.out.println("firstPage.jsp");
System.out.println("First의 pageContext 객체 : " + pageContext.getAttribute("name"));
System.out.println("First의 request 객체 : " + request.getAttribute("name"));
System.out.println("First의 session 객체 : " + session.getAttribute("name"));
System.out.println("First의 application 객체 : " + application.getAttribute("name"));

RequestDispatcher dispatcher = request.getRequestDispatcher("092_ObjectLife.jsp");
dispatcher.forward(request, response);
%>
</body>
</html>