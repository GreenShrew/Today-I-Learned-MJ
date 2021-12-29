<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
second의 pageContext 속성 : <%=pageContext.getAttribute("name") %>	<!-- null -->
second의 request 속성 : <%=request.getAttribute("name") %>
second의 session 속성 : <%=session.getAttribute("name") %>
second의 application 속성 : <%=application.getAttribute("name") %>
<a href="093_ObjectLife.jsp">또 다른 페이지</a>
</h1>
</body>
</html>