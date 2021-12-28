<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 폼 제작시 action 란에는 서블릿과 데이터베이스를 이용한 로그인을 할 때는 서블릿 이름을 써서 이동하게 한다. -->
<!-- 다만 지금은 아직 데이터베이스와의 연동이 미진행되어있으므로 약식 로그인 폼과 동작만 제작한다. -->
<form method="post" action="072_Login_do.jsp">
	<label for="id"> 아이디 : </label>
	<input type="text" id="id" name="id"><br>
	<label for="pwd"> 암 &nbsp; 호 : </label>
	<input type="password" id="pwd" name="pwd"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>