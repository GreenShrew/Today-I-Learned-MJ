<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<!-- 안녕하세요 -->
<%
// response.sendRedirect("member/loginForm.jsp");		이런식으로 보내면 경로가 노출이 되므로 Servlet을 거쳐서 보낸다.
response.sendRedirect("login.do");	// 얘는 LoginServlet의 goGet으로 간다. -->
%>	<!-- index 화면이 표시되어 경로가 노출되기 전에 Servlet으로 이동시킨다. -->
<!-- 그리고 Servlet에서 내가 보내려고 하는 페이지로 Forward 시킨다. -->
</body>
</html>