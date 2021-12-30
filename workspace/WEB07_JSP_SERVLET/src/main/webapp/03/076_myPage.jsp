<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>076_myPage</title>
</head>
<body>
<%
if(session.getAttribute("loginUser")==null){
	response.sendRedirect("071_LoginForm.jsp");
}else{
%>
	아이디 : <%=session.getAttribute("loginUser") %><br>
	성명 : 홍길동<br>
	주소 : 서울특별시<br>
	전화번호 : 010-XXXX-XXXX<br>
	주민등록번호 : 123456-7891011<br><br>
	<input type="button" value="정보수정"/>
<%
}
%>
</body>
</html>