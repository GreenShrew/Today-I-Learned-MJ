<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>073_main</title>
</head>
<body>
<%
	if(session.getAttribute("loginUser") == null){
		response.sendRedirect("071_LoginForm.jsp");		// 로그인창으로 되돌아감. 로그인 안 하고 이 사이트로 바로 접속하면 session값은 null값이다.
	}else{
%>
	로그인 관리자<br>전화번호 010-1234-5678<br>
	<%=session.getAttribute("loginUser") %>님 안녕하세요!<br>
	무엇을 하시겠습니까?
	<form method="get" action="075_myPage_do.jsp">
		<input type="submit" value="마이페이지">
	</form>
	<form method="get" action="074_logout_do.jsp">
		<input type="submit" value="로그아웃">
	</form>
<%} %>
</body>
</html>