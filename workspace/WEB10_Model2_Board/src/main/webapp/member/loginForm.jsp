<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
<form action="board.do" method="post" name="frm">
<input type="hidden" name="command" value="login">
	<div class="box">LOG IN</div>
	<div class="box">
		<div class="label">아이디</div>
		<div class="item"><input type="text" name="userid" id="loginid" size="20"></div>
	</div>
	<div class="box">
		<div class="label">비밀번호</div>
		<div class="item"><input type="password" name="pwd" id="loginpwd" size="20"></div>
	</div>
	<div class="box">
		<input type="submit" value="로그인" onClick="return loginCheck();">
		<input type="button" value="회원가입" 
		onClick="location.href='board.do?command=joinForm'">
	</div>
	<div class="box">${message}${param.message}</div>	<!-- 두가지 내용 중 한가지만 나오게 될 것이다. -->
</form>
</body>
</html>