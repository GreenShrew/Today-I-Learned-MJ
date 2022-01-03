<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
</head>
<body>
<form action="login.do" method="post" name="frm">	<!-- 얘는 진짜 로그인을 할 것이니깐 LoginServlet의 doPost로 간다. -->
	<table>
		<tr><td>아이디</td><td><input type="text" name="userid"></td></tr>
		<tr><td>암  호</td><td><input type="password" name="pwd"></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="로그인" onClick="return loginCheck()">
			<input type="reset" value="취소">
			<input type="button" value="회원가입"></td></tr>
			<tr><td colspan="2">${message}</td></tr>
	</table>
</form>
</body>
</html>