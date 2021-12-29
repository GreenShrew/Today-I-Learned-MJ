<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>123_ActionUser</title>
</head>
<body>
<h3>사용자로 로그인 성공</h3>
<%
// String userName = request.getParameter("userName");		// respose.sendRedirect
// String userName = (String)request.getAttribute("userName");	// Forward

// 아래가 Action Tag로 받은 내용
String userName = URLDecoder.decode(request.getParameter("userName"), "UTF-8");
out.print(userName);
%>
(<%=request.getParameter("userID") %>)님 환영합니다.
</body>
</html>