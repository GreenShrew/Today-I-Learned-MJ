<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>071_LoginForm</title>
</head>
<body>
<%
	if(session.getAttribute("loginUser") != null){	// 로그인 되어있는데 로그인 창으로 들어오면 main 페이지로 보낸다.
		response.sendRedirect("073_main.jsp");
	}else{
%>
<form method="post" action="072_Login_do.jsp">
	<label for="userid"> 아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	<label for="userpwd"> 암 &nbsp; 호 : </label>
	<input type="password" name="pwd" id="userpwd"><br>
	<input type="submit" value="로그인">
</form>
<%} %>
</body>
</html>